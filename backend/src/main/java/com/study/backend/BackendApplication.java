package com.study.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableElasticsearchRepositories(basePackages = "com.study.backend.search.repository")
@MapperScan("com.study.backend.repositorymybatis")
public class BackendApplication {

    public static void main(String[] args) {
        //解决netty冲突问题
//        System.setProperty("es.set.netty.runtime.available.processors","false");

        SpringApplication.run(BackendApplication.class, args);
    }

}
