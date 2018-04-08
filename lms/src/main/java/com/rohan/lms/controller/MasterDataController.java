package com.rohan.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.join.MasterData;
import com.rohan.lms.service.MasterDataService;

@RestController
@RequestMapping("/master-data")
public class MasterDataController {
	
	@Autowired
	private MasterDataService mds;
	
	@GetMapping
	public MasterData getAll() {
		return mds.getAll();
	}
}
