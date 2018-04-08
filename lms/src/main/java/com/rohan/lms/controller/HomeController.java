package com.rohan.lms.controller;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.join.UserMenu;
import com.rohan.lms.model.User;
import com.rohan.lms.repository.UserRepository;
import com.rohan.lms.service.MenuService;
import com.rohan.lms.utility.ResponseStatus;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class HomeController {
	
	@Autowired
	private UserRepository us;
	
	@Autowired
	private MenuService ms;
	
	@RequestMapping(value="/menu",method=RequestMethod.OPTIONS)
	public ResponseEntity handleOptions()
	{
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public @ResponseBody String test()
	{
		return "test successful";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user) throws ServletException
	{
		ResponseEntity<?> re = null;
		System.out.println("LoginId = "+ user.getLoginId());
		System.out.println("User Present = "+us.existsByLoginId(user.getLoginId()));
		UserMenu um = new UserMenu();
		User u = null;
		
		if(user.getLoginId()!=null && us.existsByLoginId(user.getLoginId()))
		{
			u = us.findByLoginId(user.getLoginId());
			if(user.getLoginPass().equals(u.getLoginPass()))
			{
				u.setToken(Jwts.builder()
					.setSubject(u.getLoginId())
					.claim("login_id", u.getLoginId())
					.claim("user_slno", u.getSlno())
					.claim("company_slno", u.getCompany_slno())
		            .setIssuedAt(new Date())
		            .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
				
				um.setUser(u);
				um.setMenu(ms.getMenu(u.getSlno().intValue()));
				
				re = new ResponseEntity<>(um, HttpStatus.OK);
			}
			else
			{
				//throw new ServletException("Password dosen't match");
				ResponseStatus rstat = new ResponseStatus(0,"Password dosen't match");
				re = new ResponseEntity<>(rstat,HttpStatus.UNAUTHORIZED);
			}
		}
		else
		{
			//0throw new ServletException("Login Id is not present");
			ResponseStatus rstat = new ResponseStatus(0,"Login Id is not present");
			re = new ResponseEntity<>(rstat,HttpStatus.UNAUTHORIZED);
		}
		
		
		return re;
	}
}
