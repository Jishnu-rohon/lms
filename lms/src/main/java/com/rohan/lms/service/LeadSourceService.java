package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.LeadSource;
import com.rohan.lms.repository.LeadSourceRepository;

@Service
public class LeadSourceService {
	
	@Autowired
	LeadSourceRepository lsr;
	
	public LeadSource add(LeadSource leadSource)
	{
		return lsr.save(leadSource);
	}
	
	public List<LeadSource> getAll()
	{
		return (List<LeadSource>)lsr.findAll();
	}
	
	public LeadSource getById(int slno)
	{
		return lsr.findOne(slno);
	}
	
	public LeadSource update(LeadSource leadSource)
	{
		return lsr.save(leadSource);
	}
	
	/*public void delete(LeadSource leadSource)
	{
		lsr.delete(leadSource);
	}*/
}
