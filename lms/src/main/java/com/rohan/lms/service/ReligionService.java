package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.Religion;
import com.rohan.lms.repository.ReligionRepository;

@Service
public class ReligionService {
	
	@Autowired
	ReligionRepository rr;
	
	public Religion add(Religion religion)
	{
		return rr.save(religion);
	}
	
	public List<Religion> getAll()
	{
		return (List<Religion>)rr.findAll();
	}
	
	public Religion getById(int slno)
	{
		return rr.findOne((long) slno);
	}
	
	public Religion update(Religion religion)
	{
		return rr.save(religion);
	}
	
	public void delete(Religion religion)
	{
		rr.delete(religion);
	}
}
