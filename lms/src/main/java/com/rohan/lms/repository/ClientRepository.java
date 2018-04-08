package com.rohan.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Client;
import com.rohan.lms.utility.ResponseStatus;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>,ClientRepositoryCustom {
	
	public List<Client> findAll();
	public Client findOneBySlno(Integer slno);
}
