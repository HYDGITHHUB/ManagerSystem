//package com.study.backend.search.service.impl;
//
//import com.study.backend.search.entity.Research;
//import com.study.backend.search.entity.ResearchRequest;
//import com.study.backend.search.repository.ResearchRepository;
//import com.study.backend.search.service.ResearchService;
//import com.study.backend.util.PageResult;
//import lombok.extern.slf4j.Slf4j;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
//import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.stereotype.Service;
//
//import javax.naming.directory.SearchResult;
//import java.util.*;
//
//
//@Slf4j
//@Service
//public class ResearchServiceImpl implements ResearchService {
//
//    @Autowired
//    private ResearchRepository researchRepository;
//
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
//
//    @Override
//    public Research buildGoods(Research research) {
//
//        //搜索字段
////        String all =  research1.getName();
//
//        //构建research对象
//        Research research1 = new Research();
//        research1.setId(research1.getId());
//        research1.setProject_owner(research1.getProject_owner());
//        research1.setProject_theme(research1.getProject_theme());
//        research1.setProject_type(research1.getProject_type());
//        research1.setProject_grade(research1.getProject_grade());
//
//        return research1;
//    }
//
//    @Override
//    public PageResult<Research> search(ResearchRequest request) {
//        int page = request.getPage() - 1;
//        int size = request.getSize();
//        //创建查询构建器
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//        //结果过滤
//        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{"cid", "name"}, null));
//
//        //分页
//        queryBuilder.withPageable(PageRequest.of(page, size));
//        //过滤
//        queryBuilder.withQuery(QueryBuilders.matchQuery("name", request.getKey()));
//
//        //查询
//        //Page<Goods> result = goodsRepository.search(queryBuilder.build());
//        AggregatedPage<Research> result = elasticsearchTemplate.queryForPage(queryBuilder.build(), Research.class);
//
//        //解析结果
//        //分页结果解析
//        Long total = result.getTotalElements();
//        Integer totalPages1 = result.getTotalPages();    //失效
//        Long totalPages = total % size == 0 ? total / size : total / size + 1;
//        List<Research> researchList = result.getContent();
////        Attributes researchAttribute = (Attributes)researchList;
//
//        //解析聚合结果
//
//        return new SearchResult(total.toString(), totalPages, researchList);
//    }
//}
//
