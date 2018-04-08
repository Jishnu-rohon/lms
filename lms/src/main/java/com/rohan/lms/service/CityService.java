package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.City;
import com.rohan.lms.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cr;
	
	public List<City> getAll()
	{
		return (List<City>)cr.findAll();
	}
	
	public List<City> getAllByStateSlno(int stateSlno)
	{
		return (List<City>)cr.findAllByStateSlno(stateSlno);
	}
	
	public City getById(int slno)
	{
		return cr.findOne((long) slno);
	}
}
