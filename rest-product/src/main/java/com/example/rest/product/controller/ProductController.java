package com.example.rest.product.controller;

import com.example.rest.commons.entity.Product;
import com.example.rest.commons.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/product")
@Api(value = "Endpoints to manage product")
public class ProductController {

	private final ProductService productService;

//	@GetMapping
//	@ApiOperation(value = "List all available user systems", response = Product[].class)
//	public ResponseEntity<Iterable<Product>> list(Pageable pageable) {
//		return new ResponseEntity<>(productService.list(pageable), HttpStatus.OK);
//	}

	@GetMapping
	@ApiOperation(value = "List all available products with pages")
	public Page<Product> list(
			@RequestParam(value = "page", defaultValue = "0")  Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		final Sort sort = Sort.by(Sort.Direction.ASC, "name");
		final PageRequest pageRequest = PageRequest.of(page, size, sort);
		return productService.findAll(pageRequest);
	}

	@GetMapping("{id}")
	@ApiOperation("Find product for your id")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productService.findById(id));
	}

	@PostMapping
	@ApiOperation(value = "Create new product")
	public ResponseEntity<Product> create(@RequestBody Product userSystem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(userSystem));
	}

	@PutMapping
	@ApiOperation("Update product")
	public ResponseEntity<Product> update(@RequestBody Product userSystem) {
		return ResponseEntity.ok().body(productService.save(userSystem));
	}

	@DeleteMapping("{id}")
	@ApiOperation("Delete product")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}

}













