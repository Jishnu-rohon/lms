package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.Address;
import com.rohan.lms.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository lsr;
	
	public Address add(Address address)
	{
		return lsr.save(address);
	}
	
	public List<Address> getAll()
	{
		//return (List<Address>)lsr.findAll();
		return (List<Address>)lsr.getAll();
	}
	
	public Address getById(int slno)
	{
		System.out.println("Address getById called slno = "+slno);
		return lsr.findOneBySlno(slno);
	}
	
	public Address update(Address address)
	{
		return lsr.save(address);
	}
	
	/*public void delete(Address address)
	{
		lsr.delete(address);
	}*/
}
