package com.epam.elastic.repository;

import com.epam.elastic.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer,String> {


}
