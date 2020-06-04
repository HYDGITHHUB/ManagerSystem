package com.study.backend.search.service;


import com.study.backend.search.entity.Research;
import com.study.backend.search.entity.ResearchRequest;
import com.study.backend.util.PageResult;

public interface ResearchService {

    public Research buildGoods(Research research);

    public PageResult<Research> search(ResearchRequest request);

}

