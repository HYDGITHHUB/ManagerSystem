package com.study.backend.controller;

import com.alibaba.fastjson.JSON;
import com.study.backend.config.UserLoginToken;
import com.study.backend.entity.User;
import com.study.backend.entity.UserVO;
import com.study.backend.repository.UserRepository;
import com.study.backend.util.TokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User result = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
        if (result != null) {
            String token = TokenUtil.createJwtToken(user.getName());
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            userVO.setToken(token);
            return JSON.toJSONString(userVO);
        } else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id).orElse(new User());
        return JSON.toJSONString(user);
    }

    @PutMapping("/update")
    public String update(@RequestBody User user) {
        User result = userRepository.save(user);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/curUser")
    @UserLoginToken
    public String update(HttpServletRequest request) {
        return JSON.toJSONString(request.getAttribute("CurrentUser"));
    }

}
