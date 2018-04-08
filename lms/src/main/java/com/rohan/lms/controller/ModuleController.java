package com.rohan.lms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.model.Module;
import com.rohan.lms.repository.ModuleRepository;

@RestController
@RequestMapping("/modules")
public class ModuleController {

	@Autowired
	private ModuleRepository ms;
	
	@GetMapping
	public List<Module> getAll(HttpServletRequest request)
	{
		System.out.println(request.getAttribute("claims"));
		return ms.findAll();
	}
}
