package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.ClientNature;

@Repository
public interface ClientNatureRepository extends CrudRepository<ClientNature, Long> {
	
}
