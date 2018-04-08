package com.rohan.lms.utility;

import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class DecodeHeader {
	
	public JWTHeader decode(String auth)
	{
		String token = auth.substring(7);
		Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
		Map<String, Object> crd = (Map<String, Object>)claims;
		/*System.out.println("adf da "+auth);
		System.out.println("adf da "+claims.get("login_id"));
		System.out.println("adf da "+crd.get("login_id"));*/
		return (new JWTHeader(crd.get("login_id").toString(),(int)crd.get("user_slno"),(int)crd.get("company_slno")));
	}
}
