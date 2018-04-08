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

import com.rohan.lms.model.ClientNature;
import com.rohan.lms.service.ClientNatureService;
import com.rohan.lms.utility.DecodeHeader;

@Controller
@RequestMapping("/clientNatures")
public class ClientNatureController {
	
	@Autowired
	ClientNatureService cns;
	
	@Autowired
	DecodeHeader dh;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody ClientNature add(@RequestBody ClientNature clientNature)
	{
		return cns.add(clientNature);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<ClientNature> getAll()
	{
		return cns.getAll();
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody ClientNature getById(@PathVariable("slno") int slno)
	{
		return cns.getById(slno);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody ClientNature update(@RequestBody ClientNature clientNature)
	{
		return cns.add(clientNature);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody int delete(@RequestBody ClientNature clientNature)
	{
		try {
			cns.delete(clientNature);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
