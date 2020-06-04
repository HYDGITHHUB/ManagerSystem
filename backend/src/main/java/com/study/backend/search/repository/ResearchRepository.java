package com.study.backend.search.repository;

import com.study.backend.search.entity.Research;
//import com.study.backend.search.service.ResearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchRepository extends ElasticsearchRepository<Research,String>{
//        JpaSpecificationExecutor<Research> {
//        ResearchService<Research,String> {

//        Page<Research> findDistinctByProject_ownerOrProject_themeOrProject_typeOrProject_grade(
//                String project_owner, String project_theme,
//                String project_type, String project_grade, Pageable pageable);


}
