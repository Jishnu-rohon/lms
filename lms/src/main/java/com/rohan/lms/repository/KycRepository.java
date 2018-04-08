package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Kyc;

@Repository
public interface KycRepository extends CrudRepository<Kyc, Long> {
	
}
