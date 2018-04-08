package com.rohan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.KycType;
import com.rohan.lms.repository.KycTypeRepository;

@Service
public class KycTypeService {
	
	@Autowired
	KycTypeRepository ktr;
	
	public KycType add(KycType kycType)
	{
		return ktr.save(kycType);
	}
	
	public List<KycType> getAll()
	{
		return (List<KycType>)ktr.findAll();
	}
	
	public KycType getById(int slno)
	{
		return ktr.findOne((long) slno);
	}
	
	public KycType update(KycType kycType)
	{
		return ktr.save(kycType);
	}
	
	public void delete(KycType kycType)
	{
		ktr.delete(kycType);
	}
}
