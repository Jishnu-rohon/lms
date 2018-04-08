package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.AddressType;
import com.rohan.lms.repository.AddressTypeRepository;

@Service
public class AddressTypeService {
	
	@Autowired
	AddressTypeRepository atr;
	
	public AddressType add(AddressType addressType)
	{
		return atr.save(addressType);
	}
	
	public List<AddressType> getAll()
	{
		return (List<AddressType>)atr.findAll();
	}
	
	public AddressType getById(int slno)
	{
		return atr.findOne((long) slno);
	}
	
	public AddressType update(AddressType addressType)
	{
		return atr.save(addressType);
	}
	
	public void delete(AddressType addressType)
	{
		atr.delete(addressType);
	}
}
