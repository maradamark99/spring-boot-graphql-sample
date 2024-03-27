package com.maradamark99.graphql;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "products")
public class Product {
    
    @Builder.Default
    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private String description;

    private List<String> categories;

    private Map<String, Object> attributes;

    private double price;

}
