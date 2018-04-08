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

import com.rohan.lms.model.LeadSource;
import com.rohan.lms.service.LeadSourceService;
import com.rohan.lms.utility.DecodeHeader;
import com.rohan.lms.utility.JWTHeader;

@Controller
@RequestMapping("/leadSources")
public class LeadSourceController {
	
	@Autowired
	LeadSourceService ls;
	
	@Autowired
	DecodeHeader dh;
	
	@PostMapping
	public @ResponseBody LeadSource add(@RequestBody LeadSource leadSource, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return ls.add(leadSource);
	}
	
	@GetMapping
	public @ResponseBody List<LeadSource> getAll()
	{
		return (List<LeadSource>)ls.getAll();
	}
	
	@GetMapping(value="/{slno}")
	public @ResponseBody LeadSource getById(@PathVariable("slno") int slno)
	{
		return ls.getById(slno);
	}
	
	@PutMapping
	public @ResponseBody LeadSource update(@RequestBody LeadSource leadSource, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return ls.add(leadSource);
	}
	
	/*@DeleteMapping
	public @ResponseBody int delete(@RequestBody LeadSource leadSource, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		try {
			ls.delete(leadSource);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}*/
}
