package com.study.backend.controller;

import com.study.backend.entity.ResearchProjected;
import com.study.backend.repository.ResearchProjectedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researchProjected")
public class ResearchProjectedHandler {

    @Autowired
    private ResearchProjectedRepository researchProjectedRepository;

    /**
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findAll/{page}/{size}")
    public Page<ResearchProjected> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return researchProjectedRepository.findAll(pageRequest);
    }

    /**
     *
     * @param researchProjected
     * @return
     */
    @PostMapping("/save")
    public String save(@RequestBody ResearchProjected researchProjected) {
        ResearchProjected result = researchProjectedRepository.save(researchProjected);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public ResearchProjected findById(@PathVariable("id") Integer id) {
        return researchProjectedRepository.findById(id).get();
    }

//    @GetMapping("findByName")
//    public ResearchProjected findByName(@PathVariable("name") String name) {
//        return researchProjectedRepository.findByName(name).get();
//    }

    /**
     *
     * @param researchProjected
     * @return
     */

    @PutMapping("/update")
    public String update(@RequestBody ResearchProjected researchProjected) {
        ResearchProjected result = researchProjectedRepository.save(researchProjected);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    /**
     *
     * @param id
     */

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        researchProjectedRepository.deleteById(id);
    }

//    @Query(value = "insert into research_projected(project_owner, project_time, project_theme, project_type, project_grade, project_prospect, project_describe)\n" +
//                    "select project_owner, project_time, project_theme, project_type, project_grade, project_prospect, project_describe from research_project where project_id = id;",
//                    nativeQuery = true)
//    @PostMapping("/examine/{id}")
//    public void examine(@PathVariable("id") Integer id) {
//
//    }


}
