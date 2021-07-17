package com.epam.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
@AllArgsConstructor
@Document(indexName = "customer")
public class Customer {
     public String id;
     public String name;
     public String company;
}
