package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.rohan.lms.model.ProductService;

public interface ProductServiceRepository extends CrudRepository<ProductService, Integer> {
	public ProductService findOneBySlno(Integer slno);
}
