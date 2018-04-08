package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.LeadRating;
import com.rohan.lms.repository.LeadRatingRepository;

@Service
public class LeadRatingService {
	
	@Autowired
	LeadRatingRepository lrr;
	
	public LeadRating add(LeadRating leadRating)
	{
		return lrr.save(leadRating);
	}
	
	public List<LeadRating> getAll()
	{
		return (List<LeadRating>)lrr.findAll();
	}
	
	public LeadRating getById(int slno)
	{
		return lrr.findOneBySlno(slno);
	}
	
	public LeadRating update(LeadRating leadRating)
	{
		return lrr.save(leadRating);
	}
	
	/*public void delete(LeadRating leadRating)
	{
		lrr.delete(leadRating);
	}*/
}
