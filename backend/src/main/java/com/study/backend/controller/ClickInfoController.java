package com.study.backend.controller;

import com.study.backend.entity.ClickInfo;
import com.study.backend.repository.ClickInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/clickInfo")
public class ClickInfoController {

    @Resource
    private ClickInfoRepository clickInfoRepository;

    @GetMapping("/findAll")
    public List<ClickInfo> findAll() {
        List<ClickInfo> list = clickInfoRepository.findAll();
        return list;
    }

    @GetMapping("/add/{menu}")
    public void add(@PathVariable("menu") String menu) {
        ClickInfo clickInfo = new ClickInfo();
        clickInfo.setMenu(menu);
        clickInfo.setUsername("admin");
        clickInfo.setCreateTime(LocalDateTime.now());
        clickInfoRepository.save(clickInfo);
    }


}
