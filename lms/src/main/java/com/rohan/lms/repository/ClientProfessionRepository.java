package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.ClientProfession;

@Repository
public interface ClientProfessionRepository extends CrudRepository<ClientProfession, Long> {
	
}
