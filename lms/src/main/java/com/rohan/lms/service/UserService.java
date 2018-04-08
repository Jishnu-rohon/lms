package com.rohan.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.lms.model.User;
import com.rohan.lms.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	public int getGroupByUserSlno(Long slno) {
		return ur.getGroupBySlno(slno);
	}

	public User findBySlno(long slno) {
		return ur.findBySlno(slno);
	}
}
