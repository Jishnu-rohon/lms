package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.rohan.lms.model.ClientNature;
import com.rohan.lms.repository.ClientNatureRepository;

@Service
public class ClientNatureService {
	
	@Autowired
	ClientNatureRepository cnr;
	
	public ClientNature add(ClientNature clientNature)
	{
		return cnr.save(clientNature);
	}
	
	public List<ClientNature> getAll()
	{
		return (List<ClientNature>)cnr.findAll();
	}
	
	public ClientNature getById(int slno)
	{
		return cnr.findOne((long) slno);
	}
	
	public ClientNature update(ClientNature clientNature)
	{
		return cnr.save(clientNature);
	}
	
	public void delete(ClientNature clientNature)
	{
		cnr.delete(clientNature);
	}
}
