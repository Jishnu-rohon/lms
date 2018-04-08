package com.rohan.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohan.lms.model.Lead;
import com.rohan.lms.service.LeadService;
import com.rohan.lms.utility.DecodeHeader;
import com.rohan.lms.utility.JWTHeader;

@Controller
@RequestMapping("/leads")
public class LeadController {
	
	@Autowired
	LeadService ls;
	
	@Autowired
	DecodeHeader dh;
	
	@PostMapping
	public @ResponseBody Lead add(@RequestBody Lead lead, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		lead.setCreated_by_user_slno(jh.getUser_slno());
		lead.setCompany_slno(jh.getCompany_slno());
		return ls.add(lead);
	}
	
	@GetMapping
	public @ResponseBody List<Lead> getAll(@RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		return (List<Lead>)ls.getAll(jh.getUser_slno());
	}
	
	@GetMapping(value="/{slno}")
	public @ResponseBody Lead getById(@PathVariable("slno") int slno)
	{
		return ls.getById(slno);
	}
	
	@PutMapping
	public @ResponseBody Lead update(@RequestBody Lead lead, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		lead.setCreated_by_user_slno(jh.getUser_slno());
		lead.setCompany_slno(jh.getCompany_slno());
		return ls.add(lead);
	}
	
	@DeleteMapping
	public @ResponseBody int delete(@RequestBody Lead lead, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		lead.setCreated_by_user_slno(jh.getUser_slno());
		lead.setCompany_slno(jh.getCompany_slno());
		try {
			ls.delete(lead);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
