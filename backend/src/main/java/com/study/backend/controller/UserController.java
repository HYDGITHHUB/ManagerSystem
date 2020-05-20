package com.study.backend.controller;

import com.alibaba.fastjson.JSON;
import com.study.backend.config.UserLoginToken;
import com.study.backend.entity.User;
import com.study.backend.entity.UserPersonnel;
import com.study.backend.entity.UserVO;
import com.study.backend.repository.UserRepository;
import com.study.backend.util.TokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
            BeanUtils.copyProperties(result, userVO);
            userVO.setToken(token);
            return JSON.toJSONString(userVO);
        } else {
            return "error";
        }
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return userRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody User user) {
        User result = userRepository.save(user);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

//


//    @GetMapping("/findById/{id}")
//    public String findById(@PathVariable("id") Integer id) {
//        User user = userRepository.findById(id).orElse(new User());
//        return JSON.toJSONString(user);
//    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {

        return userRepository.findById(id).get();
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

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }


    @GetMapping("/curUser")
    @UserLoginToken
    public String update(HttpServletRequest request) {
        return JSON.toJSONString(request.getAttribute("CurrentUser"));
    }

}
