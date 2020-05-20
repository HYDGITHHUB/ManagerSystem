package com.study.backend.repositorymybatis;

import com.study.backend.entity.ResearchMoneyed;

import java.util.List;

public interface ResearchMoneyedMyBatisRepository {
    public List<ResearchMoneyed> findByName(String project_owner);
}
