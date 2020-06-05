package com.study.backend.repository;

import com.study.backend.entity.ClickInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickInfoRepository extends JpaRepository<ClickInfo,Integer> {
}
