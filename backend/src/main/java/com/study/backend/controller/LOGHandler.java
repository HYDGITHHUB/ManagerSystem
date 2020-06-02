//package com.study.backend.controller;
//
//import com.study.backend.entity.LOGInfo;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.NamedThreadLocal;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import javax.servlet.http.HttpServletRequest;
//import java.text.SimpleDateFormat;
//
//@Aspect
//@Component
//public class LOGHandler {
//
//    private final Logger logger = LoggerFactory.getLogger(LOGHandler.class);
//
//    //每个请求需要记录对该请求的处理时间
//    private static final ThreadLocal<Long> startTimeThreadLocal =
//            new NamedThreadLocal<Long>("ThreadLocal StartTime");
//
//    //扫描并拦截对应包下的controller的接口
//    @Pointcut("execution(* com.study.backend.controller.*.*(..))")
//    public void LOGInfo(){
//
//    }
//    //在LOGInfo()方法执行之前执行LogRequestInfo()方法
//    @Before("LOGInfo()")
//    public void LogRequestInfo(JoinPoint joinPoint) throws Exception{
//        //拦截请求，获取请求的ip、url、方法名、参数等信息
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        long beginTime = System.currentTimeMillis();//1、开始时间
//        startTimeThreadLocal.set(beginTime);		//线程绑定变量（该数据只有当前请求的线程可见）
//        String ip = request.getRemoteAddr();
//        String url = request.getRequestURL().toString();
//        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        LOGInfo log = new LOGInfo(ip,url,classMethod,args);
//        logger.info("request : {}",log);
//    }
//
//    //在LOGInfo()方法执行之后执行LOGResultInfo()方法
//    @After("LOGInfo()")
//        public void LOGResultInfo(JoinPoint joinPoint) throws Exception {
//            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            HttpServletRequest request = attributes.getRequest();
//
//            long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
//            long endTime = System.currentTimeMillis(); 	//2、结束时间
//
//            logger.info("结束时间: {} 最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
//                    new SimpleDateFormat("hh:mm:ss.SSS").format(endTime),
//                    Runtime.getRuntime().maxMemory()/1024/1024,
//                    Runtime.getRuntime().totalMemory()/1024/1024,
//                    Runtime.getRuntime().freeMemory()/1024/1024,
//                    (Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);
//
//        }
//
//
//
//}
