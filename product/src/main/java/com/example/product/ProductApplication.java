package com.example.product;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository productRepository) {
		return args -> {
			initUsers(productRepository);
		};
	}

	private void initUsers(ProductRepository productRepository) {
		final Optional<Product> optionalProduct = productRepository.findById(1L);

		if(optionalProduct.isEmpty()) {
			final Product product = Product.builder()
					.name("Product Example")
					.build();

			productRepository.save(product);
		}


	}

}
