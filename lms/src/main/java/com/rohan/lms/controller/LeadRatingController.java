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

import com.rohan.lms.model.LeadRating;
import com.rohan.lms.service.LeadRatingService;
import com.rohan.lms.utility.DecodeHeader;
import com.rohan.lms.utility.JWTHeader;

@Controller
@RequestMapping("/leadRatings")
public class LeadRatingController {
	
	@Autowired
	LeadRatingService lrs;
	
	@Autowired
	DecodeHeader dh;
	
	@PostMapping
	public @ResponseBody LeadRating add(@RequestBody LeadRating leadRating, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return lrs.add(leadRating);
	}
	
	@GetMapping
	public @ResponseBody List<LeadRating> getAll()
	{
		return (List<LeadRating>)lrs.getAll();
	}
	
	@GetMapping(value="/{slno}")
	public @ResponseBody LeadRating getById(@PathVariable("slno") int slno)
	{
		return lrs.getById(slno);
	}
	
	@PutMapping
	public @ResponseBody LeadRating update(@RequestBody LeadRating leadRating, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		return lrs.add(leadRating);
	}
	
	/*@DeleteMapping
	public @ResponseBody int delete(@RequestBody LeadRating leadRating, @RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		try {
			lrs.delete(leadRating);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}*/
}
