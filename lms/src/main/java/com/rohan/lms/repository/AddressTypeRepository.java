package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.AddressType;

@Repository
public interface AddressTypeRepository extends CrudRepository<AddressType, Long> {
	
}
