package com.study.backend.controller;

import com.study.backend.entity.ResearchMoneyed;
import com.study.backend.entity.ResearchMoneying;
import com.study.backend.repository.ResearchMoneyingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researchMoneying")
public class ResearchMoneyingHandler {
    @Autowired
    private ResearchMoneyingRepository researchMoneyingRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<ResearchMoneying> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return researchMoneyingRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody ResearchMoneying researchMoneying) {
        ResearchMoneying result = researchMoneyingRepository.save(researchMoneying);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("findById/{id}")
    public ResearchMoneying findById(@PathVariable("id") Integer id) {
        return researchMoneyingRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody ResearchMoneying researchMoneying) {
        ResearchMoneying result = researchMoneyingRepository.save(researchMoneying);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        researchMoneyingRepository.deleteById(id);
    }

}
