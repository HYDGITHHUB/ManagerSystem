package com.study.backend.controller;

import com.study.backend.entity.UserSysManagerPersonnel;
import com.study.backend.repository.UserSysManagerPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/userSysManagerPersonnel")
public class UserSysManagerPersonnelHandler {
    @Autowired
    private UserSysManagerPersonnelRepository userSysManagerPersonnelRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<UserSysManagerPersonnel> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return userSysManagerPersonnelRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody UserSysManagerPersonnel userSysManagerPersonnel) {
        UserSysManagerPersonnel result = userSysManagerPersonnelRepository.save(userSysManagerPersonnel);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public UserSysManagerPersonnel findById(@PathVariable("id") Integer id) {
        return userSysManagerPersonnelRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody UserSysManagerPersonnel userSysManagerPersonnel) {
        UserSysManagerPersonnel result = userSysManagerPersonnelRepository.save(userSysManagerPersonnel);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userSysManagerPersonnelRepository.deleteById(id);
    }
}
