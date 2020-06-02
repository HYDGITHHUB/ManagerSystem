package com.study.backend.search;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@Document(indexName = "research",type = "research",shards = 1,replicas = 0)
public class research {

    @Id
    private String project_id;



}
