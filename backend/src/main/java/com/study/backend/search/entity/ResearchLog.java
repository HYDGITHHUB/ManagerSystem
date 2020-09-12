package com.study.backend.search.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Document(indexName = "researchlog",type = "researchlog",createIndex = true,shards = 1,replicas = 0)
public class ResearchLog {

    @Id
    private Integer id;

    private String username;

    //ik分词器
    @Field(type = FieldType.Text,searchAnalyzer = "ik_smart",analyzer = "ik_max_word")
    private String keyword;

    //ik分词器
    @Field(type = FieldType.Text,searchAnalyzer = "ik_smart",analyzer = "ik_max_word")
    private String menu;

    private LocalDateTime creat_time;
}
