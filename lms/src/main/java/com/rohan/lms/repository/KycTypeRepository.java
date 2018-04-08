package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.KycType;

@Repository
public interface KycTypeRepository extends CrudRepository<KycType, Long> {
	
}
