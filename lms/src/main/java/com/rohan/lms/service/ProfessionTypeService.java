package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.rohan.lms.model.ProfessionType;
import com.rohan.lms.repository.ProfessionTypeRepository;

@Service
public class ProfessionTypeService {
	
	@Autowired
	ProfessionTypeRepository cnr;
	
	public ProfessionType add(ProfessionType professionType)
	{
		return cnr.save(professionType);
	}
	
	public List<ProfessionType> getAll()
	{
		return (List<ProfessionType>)cnr.findAll();
	}
	
	public ProfessionType getById(int slno)
	{
		return cnr.findOne((long) slno);
	}
	
	public ProfessionType update(ProfessionType professionType)
	{
		return cnr.save(professionType);
	}
	
	public void delete(ProfessionType professionType)
	{
		cnr.delete(professionType);
	}
}
