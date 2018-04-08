package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.rohan.lms.model.LeadRating;

public interface LeadRatingRepository extends CrudRepository<LeadRating, Integer> {

	LeadRating findOneBySlno(int slno);
	
}
