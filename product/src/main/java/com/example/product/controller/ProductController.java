package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Endpoints to manage product")
public class ProductController {

	private final ProductService productService;

	@GetMapping(value = "/listAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "List all available user systems", response = Product[].class)
	public ResponseEntity<Iterable<Product>> list(Pageable pageable) {
		return new ResponseEntity<>(productService.list(pageable), HttpStatus.OK);
	}

//	@GetMapping(value = "{id}")
//	@ApiOperation(value = "Find by id")
//	public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
//		return ResponseEntity.ok().body(productService.findById(id));
//	}
}













