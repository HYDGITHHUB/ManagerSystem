package com.study.backend.repositorymybatis;

import com.study.backend.entity.ResearchResulted;

import java.util.List;

public interface ResearchResultedMyBatisRepository {
    public List<ResearchResulted> findByName(String project_owner);
}
