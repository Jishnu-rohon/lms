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

import com.rohan.lms.model.Address;
import com.rohan.lms.service.AddressService;
import com.rohan.lms.utility.DecodeHeader;
import com.rohan.lms.utility.JWTHeader;

@Controller
@RequestMapping("/addresses")
public class AddressController {
	
	@Autowired
	AddressService as;
	
	@Autowired
	DecodeHeader dh;
	
	@PostMapping
	public @ResponseBody Address add(@RequestBody Address address, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return as.add(address);
	}
	
	@GetMapping
	public @ResponseBody List<Address> getAll()
	{
		return (List<Address>)as.getAll();
	}
	
	@GetMapping(value="/{slno}")
	public @ResponseBody Address getById(@PathVariable("slno") int slno)
	{
		return as.getById(slno);
	}
	
	@PutMapping
	public @ResponseBody Address update(@RequestBody Address address, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return as.add(address);
	}
	
	/*@DeleteMapping
	public @ResponseBody int delete(@RequestBody Address address, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		try {
			as.delete(address);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}*/
}
