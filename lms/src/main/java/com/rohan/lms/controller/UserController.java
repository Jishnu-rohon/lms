package com.rohan.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.model.User;
import com.rohan.lms.repository.UserRepository;
import com.rohan.lms.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService us;
	
	@RequestMapping("/{slno}")
	public User getUserById(@PathVariable long slno)
	{
		return us.findBySlno(slno);
	}
}
