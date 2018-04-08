package com.rohan.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.model.State;
import com.rohan.lms.service.StateService;

@RestController
//@RequestMapping("/states")
public class StateController {
	
	@Autowired
	private StateService ss;
	
	@RequestMapping(value="/states",method=RequestMethod.GET)
	public @ResponseBody List<State> getAll()
	{
		return ss.getAll();
	}
	
	@RequestMapping(value="/countries/{countrySlno}/states",method=RequestMethod.GET)
	public @ResponseBody List<State> getAll(@PathVariable("countrySlno") int countrySlno)
	{
		return ss.getAllByCountrySlno(countrySlno);
	}
	
	@RequestMapping(value="/states/{slno}",method=RequestMethod.GET)
	public @ResponseBody State getById(@PathVariable("slno") int slno)
	{
		return ss.getById(slno);
	}
	
}
