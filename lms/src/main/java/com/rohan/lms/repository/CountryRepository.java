package com.rohan.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
