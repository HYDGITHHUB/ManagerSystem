package com.study.backend.repository;

import com.study.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByNameAndPassword(String name, String password);
    User findByName(String name);
}
