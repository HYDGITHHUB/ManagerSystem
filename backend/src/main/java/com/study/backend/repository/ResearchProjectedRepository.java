package com.study.backend.repository;

import com.study.backend.entity.ResearchProjected;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchProjectedRepository extends JpaRepository<ResearchProjected,Integer> {
//    ResearchProjected findByProject_id(String name);
//    ResearchProjected findByProject_theme(String project_theme);
}
