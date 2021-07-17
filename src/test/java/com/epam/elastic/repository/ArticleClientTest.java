package com.epam.elastic.repository;

import com.epam.elastic.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@SpringBootTest
public class ArticleClientTest {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void testCreateIndex(){
        elasticsearchRestTemplate.indexOps(Article.class);
    }
}
