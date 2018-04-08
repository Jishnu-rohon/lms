package com.rohan.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.State;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

	public List<State> findAllByCountrySlno(int countrySlno);
}
