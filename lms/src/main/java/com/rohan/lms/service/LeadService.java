package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.Lead;
import com.rohan.lms.repository.LeadRepository;

@Service
public class LeadService {
	
	@Autowired
	LeadRepository lr;
	
	public Lead add(Lead lead)
	{
		return lr.save(lead);
	}
	
	public List<Lead> getAll(int user_slno)
	{
		return (List<Lead>)lr.findAll(user_slno);
	}
	
	public Lead getById(int slno)
	{
		return lr.findOne((long) slno);
	}
	
	public Lead update(Lead lead)
	{
		return lr.save(lead);
	}
	
	public void delete(Lead lead)
	{
		lr.delete(lead);
	}
}
