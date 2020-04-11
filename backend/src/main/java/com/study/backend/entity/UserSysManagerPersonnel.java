package com.study.backend.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class UserSysManagerPersonnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @NotNull
    private Integer user_eno;
    @NotNull
    @Length(min = 2,max = 24)
    private String user_name;
    @NotNull
    @Length(min = 6,max = 16)
    private String user_pwd;
    private Long user_phone;
    private String user_mail;
}
