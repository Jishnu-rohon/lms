package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.Kyc;
import com.rohan.lms.repository.KycRepository;

@Service
public class KycService {
	
	@Autowired
	KycRepository kr;
	
	public Kyc add(Kyc kyc)
	{
		return kr.save(kyc);
	}
	
	public List<Kyc> getAll()
	{
		return (List<Kyc>)kr.findAll();
	}
	
	public Kyc getById(int slno)
	{
		return kr.findOne((long) slno);
	}
	
	public Kyc update(Kyc kyc)
	{
		return kr.save(kyc);
	}
	
	public void delete(Kyc kyc)
	{
		kr.delete(kyc);
	}
}
