package com.rohan.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.join.Menu;
import com.rohan.lms.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService ms;
	
	@RequestMapping("")
	public void defaults()
	{
		System.out.println("Executed");
	}
	
	@GetMapping
	public @ResponseBody List<Menu> getMenu(HttpServletRequest req)
	{
		//System.out.println("Claims = "+req.getAttribute("claims"));
		Map<String, Object> crd = (Map<String, Object>)req.getAttribute("claims");
		System.out.println("User_id = "+crd.get("user_slno"));
		return ms.getMenu((int)crd.get("user_slno"));
	}
}
