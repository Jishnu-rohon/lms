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

import com.rohan.lms.model.KycType;
import com.rohan.lms.service.KycTypeService;
import com.rohan.lms.utility.DecodeHeader;

@Controller
@RequestMapping("/kycTypes")
public class KycTypeController {
	
	@Autowired
	KycTypeService kts;
	
	@Autowired
	DecodeHeader dh;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody KycType add(@RequestBody KycType kycType)
	{
		return kts.add(kycType);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<KycType> getAll()
	{
		return kts.getAll();
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody KycType getById(@PathVariable("slno") int slno)
	{
		return kts.getById(slno);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody KycType update(@RequestBody KycType kycType)
	{
		return kts.add(kycType);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody int delete(@RequestBody KycType kycType)
	{
		try {
			kts.delete(kycType);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
