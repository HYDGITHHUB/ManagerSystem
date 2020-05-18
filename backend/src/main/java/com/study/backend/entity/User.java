package com.study.backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yangguang
 * @date 2020-05-17 15:34
 * @description
 */
@Entity
@Data
public class User {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private Integer role;
}
