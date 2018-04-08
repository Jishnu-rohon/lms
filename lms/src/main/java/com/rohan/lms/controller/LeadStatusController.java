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

import com.rohan.lms.model.LeadStatus;
import com.rohan.lms.service.LeadStatusService;
import com.rohan.lms.utility.DecodeHeader;
import com.rohan.lms.utility.JWTHeader;

@Controller
@RequestMapping("/leadStatuses")
public class LeadStatusController {
	
	@Autowired
	LeadStatusService lss;
	
	@Autowired
	DecodeHeader dh;
	
	@PostMapping
	public @ResponseBody LeadStatus add(@RequestBody LeadStatus leadStatus, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return lss.add(leadStatus);
	}
	
	@GetMapping
	public @ResponseBody List<LeadStatus> getAll()
	{
		return (List<LeadStatus>)lss.getAll();
	}
	
	@GetMapping(value="/{slno}")
	public @ResponseBody LeadStatus getById(@PathVariable("slno") int slno)
	{
		return lss.getById(slno);
	}
	
	@PutMapping
	public @ResponseBody LeadStatus update(@RequestBody LeadStatus leadStatus, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return lss.add(leadStatus);
	}
	
	/*@DeleteMapping
	public @ResponseBody int delete(@RequestBody LeadStatus leadStatus, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		try {
			lss.delete(leadStatus);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}*/
}
