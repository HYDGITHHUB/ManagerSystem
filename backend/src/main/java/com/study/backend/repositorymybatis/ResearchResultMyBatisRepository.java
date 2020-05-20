package com.study.backend.repositorymybatis;

import com.study.backend.entity.ResearchResult;

import java.util.List;

public interface ResearchResultMyBatisRepository {
    public List<ResearchResult> findByName(String project_owner);
}
