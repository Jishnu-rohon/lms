package com.rohan.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohan.lms.model.Religion;
import com.rohan.lms.service.ReligionService;
import com.rohan.lms.utility.DecodeHeader;
import com.rohan.lms.utility.JWTHeader;

@Controller
@RequestMapping("/religions")
public class ReligionController {
	
	@Autowired
	ReligionService rs;
	
	@Autowired
	DecodeHeader dh;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Religion add(@RequestBody Religion religion, @RequestHeader("Authorization") String auth)
	{
		return rs.add(religion);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Religion> getAll()
	{
		return rs.getAll();
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody Religion getById(@PathVariable("slno") int slno)
	{
		return rs.getById(slno);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody Religion update(@RequestBody Religion religion, @RequestHeader("Authorization") String auth)
	{
		return rs.add(religion);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody int delete(@RequestBody Religion religion, @RequestHeader("Authorization") String auth)
	{
		try {
			rs.delete(religion);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
