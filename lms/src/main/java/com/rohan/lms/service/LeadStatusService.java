package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.LeadStatus;
import com.rohan.lms.repository.LeadStatusRepository;

@Service
public class LeadStatusService {
	
	@Autowired
	LeadStatusRepository lsr;
	
	public LeadStatus add(LeadStatus leadStatus)
	{
		return lsr.save(leadStatus);
	}
	
	public List<LeadStatus> getAll()
	{
		return (List<LeadStatus>)lsr.findAll();
	}
	
	public LeadStatus getById(int slno)
	{
		return lsr.findOneBySlno(slno);
	}
	
	public LeadStatus update(LeadStatus leadStatus)
	{
		return lsr.save(leadStatus);
	}
	
	/*public void delete(LeadStatus leadStatus)
	{
		lsr.delete(leadStatus);
	}*/
}
