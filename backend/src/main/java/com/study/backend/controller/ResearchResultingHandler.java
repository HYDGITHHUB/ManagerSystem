package com.study.backend.controller;

import com.study.backend.entity.ResearchResult;
import com.study.backend.entity.ResearchResulting;
import com.study.backend.repository.ResearchResultingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researchResulting")
public class ResearchResultingHandler {

    @Autowired
    private ResearchResultingRepository researchResultingRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<ResearchResulting> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return researchResultingRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody ResearchResulting researchResulting) {
        ResearchResulting result = researchResultingRepository.save(researchResulting);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("findById/{id}")
    public ResearchResulting findById(@PathVariable("id") Integer id) {
        return researchResultingRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody ResearchResulting researchResulting) {
        ResearchResulting result = researchResultingRepository.save(researchResulting);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        researchResultingRepository.deleteById(id);
    }

}
