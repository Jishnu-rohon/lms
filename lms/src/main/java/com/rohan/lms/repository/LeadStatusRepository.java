package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.rohan.lms.model.LeadStatus;

public interface LeadStatusRepository extends CrudRepository<LeadStatus, Integer> {

	LeadStatus findOneBySlno(int slno);
	
}
