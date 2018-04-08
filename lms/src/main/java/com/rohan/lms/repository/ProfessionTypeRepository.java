package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.ProfessionType;

@Repository
public interface ProfessionTypeRepository extends CrudRepository<ProfessionType, Long> {
	
}
