package com.study.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class ResearchResulting {
    @Id
    @NotNull
    private Integer project_id;

    @NotNull
    private String project_owner;

    @NotNull
    private String project_state;

    @NotNull
    private Date project_time;

    private String project_result_state = "未结题";

    @NotNull
    private String project_theme;

    @NotNull
    private String project_type;

    @NotNull
    private String project_grade;

    @NotNull
    private String project_prospect;

    @NotNull
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
}
