package com.example.product.services;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

	private final ProductRepository productRepository;

	public Product findById(Long id) {
		final Optional<Product> user = productRepository.findById(id);
		return user.orElseThrow(() -> new RuntimeException("Product not found!"));
	}

	public Iterable<Product> list(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

}
