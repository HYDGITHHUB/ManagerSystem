package com.study.backend.controller;

import com.study.backend.entity.ResearchResult;
import com.study.backend.repository.ResearchResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researchResult")
public class ResearchResultHandler {

    @Autowired
    private ResearchResultRepository researchResultRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<ResearchResult> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return researchResultRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody ResearchResult researchResult) {
        ResearchResult result = researchResultRepository.save(researchResult);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("findById/{id}")
    public ResearchResult findById(@PathVariable("id") Integer id) {
        return researchResultRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody ResearchResult researchResult) {
        ResearchResult result = researchResultRepository.save(researchResult);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        researchResultRepository.deleteById(id);
    }

}
