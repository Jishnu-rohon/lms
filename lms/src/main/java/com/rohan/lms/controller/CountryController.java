package com.rohan.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.model.Country;
import com.rohan.lms.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryService cs;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Country> getAll()
	{
		return (List<Country>)cs.getAll();
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody Country getById(@PathVariable("slno") int slno)
	{
		return cs.getById(slno);
	}
	
}
