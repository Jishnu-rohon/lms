package com.rohan.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohan.lms.model.Client;
import com.rohan.lms.service.ClientService;
import com.rohan.lms.utility.DecodeHeader;
import com.rohan.lms.utility.JWTHeader;
import com.rohan.lms.utility.ResponseStatus;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	ClientService cs;
	
	@Autowired
	DecodeHeader dh;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> add(@RequestBody Client client, @RequestHeader("Authorization") String auth)
	{
		ResponseEntity<?> re = null;
		ResponseStatus rs = null;
		
		System.out.println("add Client = "+client);
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh + " user_slno = "+ jh.getUser_slno());
		
		client.setCreated_by_user_slno(jh.getUser_slno());
		client.setCompany_slno(jh.getCompany_slno());
		
		client.getAddresses();
		
		rs = cs.addClient(client);
		
		if(rs.getStatus()==1)
		{
			re = new ResponseEntity<>(rs,HttpStatus.OK);
		}
		else
		{
			re = new ResponseEntity<>(rs,HttpStatus.BAD_REQUEST);
		}

		return re;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Client> getAll(@RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		return (List<Client>)cs.getAll(jh.getUser_slno());
	}
	
	@RequestMapping(value="/deleted",method=RequestMethod.GET)
	public @ResponseBody List<Client> getAllDeleted(@RequestHeader("Authorization") String auth)
	{
		JWTHeader jh = dh.decode(auth);
		return (List<Client>)cs.getAllDeleted(jh.getUser_slno());
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.GET)
	public @ResponseBody Client getById(@PathVariable("slno") int slno)
	{
		System.out.println("cslno = "+slno+" Client = "+cs.getById(slno));
		return cs.getById(slno);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<?> update(@RequestBody Client client, @RequestHeader("Authorization") String auth)
	{
		ResponseEntity<?> re = null;
		ResponseStatus rs = null;
		
		JWTHeader jh = dh.decode(auth);
		System.out.println("Auth header = "+ jh);
		client.setCreated_by_user_slno(jh.getUser_slno());
		client.setCompany_slno(jh.getCompany_slno());
		
		rs = cs.updateClient(client);
		
		if(rs.getStatus()==1)
		{
			re = new ResponseEntity<>(rs,HttpStatus.OK);
		}
		else
		{
			re = new ResponseEntity<>(rs,HttpStatus.BAD_REQUEST);
		}
		
		return re;
	}
	
	@RequestMapping(value="/{slno}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> delete(@PathVariable Integer slno)
	{
		ResponseEntity<?> re = null;
		ResponseStatus rs = null;
		
		try {
			rs = cs.deleteClient(slno);
			
			if(rs.getStatus()==1) {
				re = new ResponseEntity<>(rs,HttpStatus.OK);
			}
			else {
				re = new ResponseEntity<>(rs,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			re = new ResponseEntity<>(new ResponseStatus(0, "Delete not successful"),HttpStatus.BAD_REQUEST);
		}
		
		return re;
	}
	
	@RequestMapping(value="/{slno}/restore",method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<?> restore(@PathVariable Integer slno)
	{
		ResponseEntity<?> re = null;
		ResponseStatus rs = null;
		
		try {
			rs = cs.restoreClient(slno);
			
			if(rs.getStatus()==1) {
				re = new ResponseEntity<>(rs,HttpStatus.OK);
			}
			else {
				re = new ResponseEntity<>(rs,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			re = new ResponseEntity<>(new ResponseStatus(0, "Restore not successful"),HttpStatus.BAD_REQUEST);
		}
		
		return re;
	}
}
