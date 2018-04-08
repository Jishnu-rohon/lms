package com.rohan.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohan.lms.model.ProductService;
import com.rohan.lms.service.ProductServiceService;
import com.rohan.lms.utility.DecodeHeader;
import com.rohan.lms.utility.JWTHeader;

@Controller
@RequestMapping("/productServices")
public class ProductServiceController {
	
	@Autowired
	ProductServiceService pss;
	
	@Autowired
	DecodeHeader dh;
	
	@PostMapping
	public @ResponseBody ProductService add(@RequestBody ProductService productService, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return pss.add(productService);
	}
	
	@GetMapping
	public @ResponseBody List<ProductService> getAll()
	{
		return (List<ProductService>)pss.getAll();
	}
	
	@GetMapping(value="/{slno}")
	public @ResponseBody ProductService getById(@PathVariable("slno") int slno)
	{
		return pss.getById(slno);
	}
	
	@PutMapping
	public @ResponseBody ProductService update(@RequestBody ProductService productService, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return pss.add(productService);
	}
	
	/*@DeleteMapping
	public @ResponseBody int delete(@RequestBody ProductService productService, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		try {
			pss.delete(productService);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}*/
}
