package com.epam.elastic.repository;

import com.epam.elastic.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerServices {

    public void saveCustomer(Customer customer);
    public void updateCustomer(Customer customer);
        public Customer findById(String id);
    public List<Customer> findByName(String name);
//    public List<Customer> findAll();
    public void deleteCustomer(String id);
}
