package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.ProductService;
import com.rohan.lms.repository.ProductServiceRepository;

@Service
public class ProductServiceService {
	
	@Autowired
	ProductServiceRepository psr;
	
	public ProductService add(ProductService productService)
	{
		return psr.save(productService);
	}
	
	public List<ProductService> getAll()
	{
		return (List<ProductService>)psr.findAll();
	}
	
	public ProductService getById(int slno)
	{
		return psr.findOneBySlno(slno);
	}
	
	public ProductService update(ProductService productService)
	{
		return psr.save(productService);
	}
	
	/*public void delete(ProductService productService)
	{
		psr.delete(productService);
	}*/
}
