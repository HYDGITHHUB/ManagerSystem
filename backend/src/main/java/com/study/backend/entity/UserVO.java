package com.study.backend.entity;

import lombok.Data;

/**
 * @author yangguang
 * @date 2020-05-17 21:31
 * @description
 */
@Data
public class UserVO {
    private Integer id;

    private String name;

    private String password;

    private Integer role;

    private String token;
}
