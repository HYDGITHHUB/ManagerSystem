package com.study.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class ResearchMoneying {
    @Id
    @NotNull
    private Integer project_id;

    @NotNull
    private String project_owner;

    @NotNull
    private String project_state;

    @NotNull
    private Date project_time;

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
}
