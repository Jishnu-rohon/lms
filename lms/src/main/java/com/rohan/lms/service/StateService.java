package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.State;
import com.rohan.lms.repository.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository sr;
	
	public List<State> getAll()
	{
		return (List<State>)sr.findAll();
	}
	
	public List<State> getAllByCountrySlno(int countrySlno)
	{
		return sr.findAllByCountrySlno(countrySlno);
	}
	
	public State getById(int slno)
	{
		return sr.findOne((long) slno);
	}
}
