package com.maradamark99.graphql;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProductController {
    
    private final ProductRepository productRepository;

    @QueryMapping
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument String id) {
        return productRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Product saveProduct(@Argument ProductInput product) {
        var productToSave = Product.builder()
            .name(product.name())
            .description(product.description())
            .categories(product.categories())
            .attributes(product.attributes())
            .price(product.price())
            .build();
        return productRepository.save(productToSave);
    }

    @MutationMapping
    public boolean deleteProduct(@Argument String id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

}
