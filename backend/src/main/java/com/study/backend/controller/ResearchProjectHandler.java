package com.study.backend.controller;

import com.study.backend.entity.ResearchProject;
import com.study.backend.repository.ResearchProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researchProject")
public class ResearchProjectHandler {

    @Autowired
    private ResearchProjectRepository researchProjectRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<ResearchProject> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return researchProjectRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody ResearchProject researchProject) {
        ResearchProject result = researchProjectRepository.save(researchProject);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("findById/{id}")
    public ResearchProject findById(@PathVariable("id") Integer id) {
        return researchProjectRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody ResearchProject researchProject) {
        ResearchProject result = researchProjectRepository.save(researchProject);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        researchProjectRepository.deleteById(id);
    }
}
