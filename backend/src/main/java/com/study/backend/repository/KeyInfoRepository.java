package com.study.backend.repository;

import com.study.backend.entity.KeyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface KeyInfoRepository extends JpaRepository<KeyInfo,Integer> {

    List<KeyInfo> findByKeyword(String keyword);

    @Query(nativeQuery =true,value = "select keyword as name, count(keyword) as value from key_info GROUP BY keyword;")
    List<Map<Object,Object>> getCount();
}
