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

import com.rohan.lms.model.Gender;
import com.rohan.lms.service.GenderService;
import com.rohan.lms.utility.DecodeHeader;

@Controller
@RequestMapping("/genders")
public class GenderController {
	
	@Autowired
	GenderService gs;
	
	@Autowired
	DecodeHeader dh;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Gender add(@RequestBody Gender gender)
	{
		return gs.add(gender);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Gender> getAll()
	{
		return gs.getAll();
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody Gender getById(@PathVariable("slno") int slno)
	{
		return gs.getById(slno);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody Gender update(@RequestBody Gender gender)
	{
		return gs.add(gender);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody int delete(@RequestBody Gender gender)
	{
		try {
			gs.delete(gender);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
