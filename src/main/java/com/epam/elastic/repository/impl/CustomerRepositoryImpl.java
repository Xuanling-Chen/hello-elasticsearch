package com.epam.elastic.repository.impl;

import com.epam.elastic.model.Customer;
import com.epam.elastic.repository.CustomerRepository;
import com.epam.elastic.repository.CustomerServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.UpdateByQueryRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import javax.management.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerServices {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void saveCustomer(Customer customer) {
        elasticsearchRestTemplate.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        elasticsearchRestTemplate.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return elasticsearchRestTemplate.get(id.toString(), Customer.class);
    }


    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customersList = new ArrayList<>();
        BoolQueryBuilder builder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("name", name));
        NativeSearchQuery query = new NativeSearchQuery(builder);
        SearchHits<Customer> searchHits = elasticsearchRestTemplate.search(query, Customer.class);
        List<SearchHit<Customer>> searchHits1 = searchHits.getSearchHits();
        if (!searchHits1.isEmpty()) {
            searchHits1.forEach(hits -> {
                    Customer c = objectMapper.convertValue(hits.getContent(),Customer.class);
                    customersList.add(c);
                System.out.println(hits.getContent().toString());
                System.out.println("--------------------------------");
            });

        }
        return customersList;
    }


    @Override
    public void deleteCustomer(String id) {

    }
}
