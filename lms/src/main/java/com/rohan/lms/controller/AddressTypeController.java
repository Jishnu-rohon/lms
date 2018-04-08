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

import com.rohan.lms.model.AddressType;
import com.rohan.lms.service.AddressTypeService;
import com.rohan.lms.utility.DecodeHeader;

@Controller
@RequestMapping("/address-types")
public class AddressTypeController {
	
	@Autowired
	AddressTypeService ats;
	
	@Autowired
	DecodeHeader dh;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody AddressType add(@RequestBody AddressType addressType, @RequestHeader("Authorization") String auth)
	{
		return ats.add(addressType);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<AddressType> getAll()
	{
		return (List<AddressType>)ats.getAll();
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody AddressType getById(@PathVariable("slno") int slno)
	{
		return ats.getById(slno);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody AddressType update(@RequestBody AddressType addressType, @RequestHeader("Authorization") String auth)
	{
		return ats.add(addressType);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody int delete(@RequestBody AddressType addressType, @RequestHeader("Authorization") String auth)
	{
		try {
			ats.delete(addressType);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
