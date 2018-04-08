package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.Country;
import com.rohan.lms.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository cr;
	
	public List<Country> getAll()
	{
		return (List<Country>)cr.findAll();
	}
	
	public Country getById(int slno)
	{
		return cr.findOne((long) slno);
	}
}
