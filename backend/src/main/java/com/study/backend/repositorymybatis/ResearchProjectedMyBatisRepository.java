package com.study.backend.repositorymybatis;

import com.study.backend.entity.ResearchProjected;

import java.util.List;

public interface ResearchProjectedMyBatisRepository {
    public List<ResearchProjected> findByName(String project_owner);
}
