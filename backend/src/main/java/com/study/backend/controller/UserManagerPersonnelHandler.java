package com.study.backend.controller;


import com.study.backend.entity.UserManagerPersonnel;
import com.study.backend.repository.UserManagerPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/userManagerPersonnel")
public class UserManagerPersonnelHandler {
    @Autowired
    private UserManagerPersonnelRepository userManagerPersonnelRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<UserManagerPersonnel> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return userManagerPersonnelRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody UserManagerPersonnel userPersonnel) {
        UserManagerPersonnel result = userManagerPersonnelRepository.save(userPersonnel);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public UserManagerPersonnel findById(@PathVariable("id") Integer id) {
        return userManagerPersonnelRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody UserManagerPersonnel userPersonnel) {
        UserManagerPersonnel result = userManagerPersonnelRepository.save(userPersonnel);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userManagerPersonnelRepository.deleteById(id);
    }
}
