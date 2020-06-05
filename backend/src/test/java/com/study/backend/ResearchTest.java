package com.study.backend;

import com.study.backend.search.entity.Research;
//import com.study.backend.search.repository.ResearchRepository;
import com.study.backend.search.repository.ResearchRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class ResearchTest {

    @Autowired
    private ResearchRepository researchRepository;

    @Test
    void testElasticSearch() {
        researchRepository.findAll().iterator()
                .forEachRemaining(research -> System.out.println(research.getId()));
    }

//    @Test
//    public void findDistinctResearchByProject_ownerOrProject_themeOrProject_typeOrProject_grade() throws Exception {
//        Sort sort = null;
//        Pageable pageable = PageRequest.of(0,20);
//        String project_owner = "韩勇";
//        String project_theme = "能量守恒";
//        String project_type = "应用性";
//        String project_grade = "国家级";
//        Page<Research> page = researchRepository.findResearchByProject_ownerOrProject_themeOrProject_typeOrProject_grade(project_owner, project_theme,project_type,project_grade, pageable);
//        System.out.println(page);
//        System.out.println("---start---");
//        for(Research research : page.getContent()) {
//            System.out.println(research.toString());
//        }
//        System.out.println("---end---");
//    }

}
