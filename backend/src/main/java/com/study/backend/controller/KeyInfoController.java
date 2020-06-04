package com.study.backend.controller;

import com.study.backend.entity.KeyInfo;
import com.study.backend.repository.KeyInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/keyInfo")
public class KeyInfoController {

    @Resource
    private KeyInfoRepository keyInfoRepository;

    @GetMapping("/findAll")
    public List<Map<Object,Object>> findAll() {
        List<Map<Object,Object>> map = keyInfoRepository.getCount();
        return map;
    }

    @GetMapping("/add/{key}")
    public void add(@PathVariable("key") String key) {
        KeyInfo keyInfo = new KeyInfo();
        keyInfo.setKeyword(key);
        keyInfo.setUsername("admin");
        keyInfo.setCreateTime(LocalDateTime.now());
        keyInfoRepository.save(keyInfo);
    }

}
