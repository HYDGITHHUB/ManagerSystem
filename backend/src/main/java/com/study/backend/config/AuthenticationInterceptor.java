package com.study.backend.config;

import com.study.backend.entity.User;
import com.study.backend.repository.UserRepository;
import com.study.backend.util.TokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author
 * @date 2020-05-17 21:19
 * @description
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object object){
        //设置允许哪些域名应用进行ajax访问
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", " Origin, X-Requested-With, content-Type, Accept, Authorization");
        httpServletResponse.setHeader("Access-Control-Max-Age","3600");
        //获取请求头的token
        String token=httpServletRequest.getHeader("Authorization");
        //如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod) object;
        Method method=handlerMethod.getMethod();
        //检查是否有passToken注释，有则跳过验证
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken=method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }
        //检查是否有需要用户权限的注解
        if(method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken=method.getAnnotation(UserLoginToken.class);
            if(userLoginToken.required()){
                //执行认证
                if(token==null){
                    throw new RuntimeException("无token，请重新登录");
                }else {
                    //获取token中的用户信息
                    Claims claims;
                    try{
                        claims= TokenUtil.parseJWT(token);

                    }catch (ExpiredJwtException e){
                        throw new RuntimeException("401,token失效");
                    }
                    String name=claims.getId();
                    User user=userRepository.findByName(name);
                    if(user==null){
                        throw new RuntimeException("用户不存在，请重新登录");
                    }
                    httpServletRequest.setAttribute("CurrentUser",user);
                }
            }
        }
        return true;
    }
    // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e)throws Exception{

    }
}