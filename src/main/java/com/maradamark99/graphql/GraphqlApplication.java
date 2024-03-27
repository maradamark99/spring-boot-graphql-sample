package com.maradamark99.graphql;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(ProductRepository productRepository) {
		return args -> {
			var faker = new Faker();
			IntStream.range(0, 100).forEach(i -> {
				productRepository.save(
					Product.builder()
						.name(faker.commerce().productName())
						.description(faker.lorem().paragraph())
						.categories(List.of("Category 1", "Category 2"))
						.attributes(Map.of("key1", "value1", "key2", "value2"))
						.price(Double.valueOf(faker.commerce().price()))
						.build()
				);
			});
		};
	}

}
