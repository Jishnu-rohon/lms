package com.rohan.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.join.MasterData;
import com.rohan.lms.repository.MasterDataRepository;

@Service
public class MasterDataService {
	
	@Autowired
	private MasterDataRepository mdr;
	
	public MasterData getAll()
	{
		return mdr.getAll();
	}
}
