package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.Gender;
import com.rohan.lms.repository.GenderRepository;

@Service
public class GenderService {
	
	@Autowired
	GenderRepository gr;
	
	public Gender add(Gender gender)
	{
		return gr.save(gender);
	}
	
	public List<Gender> getAll()
	{
		return (List<Gender>)gr.findAll();
	}
	
	public Gender getById(int slno)
	{
		return gr.findOne((long) slno);
	}
	
	public Gender update(Gender gender)
	{
		return gr.save(gender);
	}
	
	public void delete(Gender gender)
	{
		gr.delete(gender);
	}
}
