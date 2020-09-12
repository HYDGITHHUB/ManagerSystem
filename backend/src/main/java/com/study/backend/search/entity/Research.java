package com.study.backend.search.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Document(indexName = "research",type = "research",shards = 1,replicas = 0)
public class Research implements Serializable {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String project_owner;

    private String project_state;

    private Date project_time;

    private Date project_tim_end;

    private String project_result_state;

    //ik分词器
    @Field(type = FieldType.Text,searchAnalyzer = "ik_smart",analyzer = "ik_max_word")
    private String project_theme;

    @Field(type = FieldType.Keyword)
    private String project_type;

    @Field(type = FieldType.Keyword)
    private String project_grade;

    private String project_prospect;

    private String project_describe;

    private Integer project_money;

    private Integer project_moneyed;

    private String project_result_type;


    private String project_monograph_type;


    private String project_monograph_content;

    private String project_press_type;

    private String project_press_content;

    private String project_patent_type;

    private String project_patent_content;

    private String project_technology_type;

    private String project_technology_content;

    private String project_result_grade;

    private String project_result_comment;
}
