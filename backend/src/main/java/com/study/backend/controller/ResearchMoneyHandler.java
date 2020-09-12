package com.study.backend.controller;

import com.study.backend.entity.ResearchMoney;
import com.study.backend.repository.ResearchMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researchMoney")
public class ResearchMoneyHandler {

    @Autowired
    private ResearchMoneyRepository researchMoneyRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<ResearchMoney> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return researchMoneyRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody ResearchMoney researchMoney) {
        ResearchMoney result = researchMoneyRepository.save(researchMoney);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("findById/{id}")
    public ResearchMoney findById(@PathVariable("id") Integer id) {
        return researchMoneyRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody ResearchMoney researchMoney) {
        ResearchMoney result = researchMoneyRepository.save(researchMoney);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        researchMoneyRepository.deleteById(id);
    }

}
