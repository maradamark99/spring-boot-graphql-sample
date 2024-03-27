package com.maradamark99.graphql;

import java.util.List;
import java.util.Map;

public record ProductInput(
    String name,
    String description,
    List<String> categories,
    Map<String, Object> attributes,
    double price
) {
    
}
