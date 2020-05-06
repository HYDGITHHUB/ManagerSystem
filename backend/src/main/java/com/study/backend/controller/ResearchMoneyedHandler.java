package com.study.backend.controller;

import com.study.backend.entity.ResearchMoneyed;
import com.study.backend.repository.ResearchMoneyedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researchMoneyed")
public class ResearchMoneyedHandler {
    @Autowired
    private ResearchMoneyedRepository researchMoneyedRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<ResearchMoneyed> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return researchMoneyedRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody ResearchMoneyed researchMoneyed) {
        ResearchMoneyed result = researchMoneyedRepository.save(researchMoneyed);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("findById/{id}")
    public ResearchMoneyed findById(@PathVariable("id") Integer id) {
        return researchMoneyedRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody ResearchMoneyed researchMoneyed) {
        ResearchMoneyed result = researchMoneyedRepository.save(researchMoneyed);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        researchMoneyedRepository.deleteById(id);
    }
}
