package com.epam.elastic.repository;

import com.epam.elastic.model.Customer;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerServices customerServices;


    @Test
    public void testSave() {
        Customer customer = Customer.builder().id("2").name("DBS").company("dbs.com").build();
        customerServices.saveCustomer(customer);
    }

    @Test
    public void testQueryById(){
        Customer customer = customerServices.findById("1");
        System.out.println(customer.getCompany());
    }

    @Test
    public void testQueryByName(){

        List<Customer> customer = customerServices.findByName("DBS");
        customer.forEach(c -> System.out.println(c.getCompany()));

    }

    @Test
    public void testUpdate(){
        Customer customer = customerServices.findById("2");
        customer.setName("digital bank of Singapore");
        customerServices.updateCustomer(customer);
    }
    @Test
    public void testFindAll(){
      Iterable<Customer> customers = customerRepository.findAll();
      customers.forEach(c ->
              System.out.println(c.getCompany()));
    }
}
