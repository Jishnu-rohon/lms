package com.rohan.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohan.lms.model.Kyc;
import com.rohan.lms.service.KycService;
import com.rohan.lms.utility.DecodeHeader;

@Controller
@RequestMapping("/kycs")
public class KycController {
	
	@Autowired
	KycService ks;
	
	@Autowired
	DecodeHeader dh;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Kyc add(@RequestBody Kyc kyc)
	{
		return ks.add(kyc);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Kyc> getAll()
	{
		return ks.getAll();
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody Kyc getById(@PathVariable("slno") int slno)
	{
		return ks.getById(slno);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody Kyc update(@RequestBody Kyc kyc)
	{
		return ks.add(kyc);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody int delete(@RequestBody Kyc kyc)
	{
		try {
			ks.delete(kyc);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
