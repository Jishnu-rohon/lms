package com.rohan.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.model.City;
import com.rohan.lms.service.CityService;

@RestController
//@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityService cs;
	
	@RequestMapping(value="/cities",method=RequestMethod.GET)
	public @ResponseBody List<City> getAll()
	{
		return cs.getAll();
	}
	
	@RequestMapping(value="/states/{stateSlno}/cities",method=RequestMethod.GET)
	public @ResponseBody List<City> getAll(@PathVariable("stateSlno") int stateSlno)
	{
		return cs.getAllByStateSlno(stateSlno);
	}
	
	@RequestMapping(value="/cities/{slno}",method=RequestMethod.GET)
	public @ResponseBody City getById(@PathVariable("slno") int slno)
	{
		return cs.getById(slno);
	}
	
}
