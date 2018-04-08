package com.rohan.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.lms.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

	public List<City> findAllByStateSlno(int stateSlno);
}
