package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Gender;

@Repository
public interface GenderRepository extends CrudRepository<Gender, Long> {
	
}
