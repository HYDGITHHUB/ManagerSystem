package com.study.backend.controller;

import com.study.backend.entity.UserPersonnel;
import com.study.backend.repository.UserPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/userPersonnel")
public class UserPersonnelHandler {
    @Autowired
    private UserPersonnelRepository userPersonnelRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<UserPersonnel> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return userPersonnelRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody UserPersonnel userPersonnel) {
        UserPersonnel result = userPersonnelRepository.save(userPersonnel);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

}
