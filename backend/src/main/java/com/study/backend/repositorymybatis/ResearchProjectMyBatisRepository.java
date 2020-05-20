package com.study.backend.repositorymybatis;

import com.study.backend.entity.ResearchProject;

import java.util.List;

public interface ResearchProjectMyBatisRepository {
    public List<ResearchProject> findByName(String project_owner);
}
