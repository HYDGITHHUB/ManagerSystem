package com.study.backend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserPersonnelRepositoryTest {

    @Autowired
    private UserPersonnelRepository userPersonnelRepository;

    @Test
    void findAll() {
        System.out.println(userPersonnelRepository.findAll());
    }

}