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

import com.rohan.lms.model.ProfessionType;
import com.rohan.lms.service.ProfessionTypeService;
import com.rohan.lms.utility.DecodeHeader;

@Controller
@RequestMapping("/professionTypes")
public class ProfessionTypeController {
	
	@Autowired
	ProfessionTypeService pts;
	
	@Autowired
	DecodeHeader dh;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody ProfessionType add(@RequestBody ProfessionType professionType)
	{
		return pts.add(professionType);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<ProfessionType> getAll()
	{
		return pts.getAll();
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody ProfessionType getById(@PathVariable("slno") int slno)
	{
		return pts.getById(slno);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody ProfessionType update(@RequestBody ProfessionType professionType)
	{
		return pts.add(professionType);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody int delete(@RequestBody ProfessionType professionType)
	{
		try {
			pts.delete(professionType);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
