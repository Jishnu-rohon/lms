package com.rohan.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohan.lms.model.ClientProfession;
import com.rohan.lms.service.ClientProfessionService;
import com.rohan.lms.utility.DecodeHeader;

@Controller
@RequestMapping("/clientProfessions")
public class ClientProfessionController {
	
	@Autowired
	ClientProfessionService cps;
	
	@Autowired
	DecodeHeader dh;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody ClientProfession add(@RequestBody ClientProfession clientProfession)
	{
		return cps.add(clientProfession);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<ClientProfession> getAll()
	{
		return cps.getAll();
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody ClientProfession getById(@PathVariable("slno") int slno)
	{
		return cps.getById(slno);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody ClientProfession update(@RequestBody ClientProfession clientProfession)
	{
		return cps.add(clientProfession);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody int delete(@RequestBody ClientProfession clientProfession)
	{
		try {
			cps.delete(clientProfession);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
