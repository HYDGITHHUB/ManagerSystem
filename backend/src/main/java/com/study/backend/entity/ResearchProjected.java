package com.study.backend.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class ResearchProjected {

    @Id
    @NotNull
    private Integer project_id;

    @NotNull
    private String project_owner;

    private String project_state = "已审核";

    @CreatedDate
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

}
