package com.study.backend.controller;

import com.study.backend.entity.ResearchResulted;
import com.study.backend.repository.ResearchResultedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researchResulted")
public class ResearchResultedHandler {
    @Autowired
    private ResearchResultedRepository researchResultedRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<ResearchResulted> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return researchResultedRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody ResearchResulted researchResulted) {
        ResearchResulted result = researchResultedRepository.save(researchResulted);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("findById/{id}")
    public ResearchResulted findById(@PathVariable("id") Integer id) {
        return researchResultedRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody ResearchResulted researchResulted) {
        ResearchResulted result = researchResultedRepository.save(researchResulted);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        researchResultedRepository.deleteById(id);
    }

}
