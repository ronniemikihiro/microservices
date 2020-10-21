package com.example.product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.product.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
