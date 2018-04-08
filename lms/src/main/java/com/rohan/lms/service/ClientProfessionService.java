package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.ClientProfession;
import com.rohan.lms.repository.ClientProfessionRepository;

@Service
public class ClientProfessionService {
	
	@Autowired
	ClientProfessionRepository cpr;
	
	public ClientProfession add(ClientProfession clientProfession)
	{
		return cpr.save(clientProfession);
	}
	
	public List<ClientProfession> getAll()
	{
		return (List<ClientProfession>)cpr.findAll();
	}
	
	public ClientProfession getById(int slno)
	{
		return cpr.findOne((long) slno);
	}
	
	public ClientProfession update(ClientProfession clientProfession)
	{
		return cpr.save(clientProfession);
	}
	
	public void delete(ClientProfession clientProfession)
	{
		cpr.delete(clientProfession);
	}
}
