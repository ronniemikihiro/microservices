package com.example.rest.commons.service;

import com.example.rest.commons.entity.Product;
import com.example.rest.commons.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

	private final ProductRepository productRepository;

	public Iterable<Product> list(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	public Product findById(Long id) {
		Optional<Product> user = productRepository.findById(id);
		return user.orElseThrow(() -> new RuntimeException("Product not found!"));
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(Long id) {
		final Optional<Product> product = productRepository.findById(id);
		product.map(u -> {
			productRepository.delete(u);
			return Void.TYPE;
		}).orElseThrow(() -> new RuntimeException("Product not found!"));
	}

}
