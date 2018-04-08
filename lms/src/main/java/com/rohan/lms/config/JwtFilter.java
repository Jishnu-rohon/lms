package com.rohan.lms.config;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        
     // Authorize (allow) all domains to consume the content
        ((HttpServletResponse) res).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) res).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
        ((HttpServletResponse) res).setHeader("Access-Control-Max-Age", "3600");
//        ((HttpServletResponse) res).setHeader("Access-Control-Allow-Credentials", "true");
        ((HttpServletResponse) res).setHeader("Access-Control-Allow-Headers", "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
        ((HttpServletResponse) res).addHeader("Access-Control-Expose-Headers", "xsrf-token");
        String path = ((HttpServletRequest) request).getRequestURI();
        
        System.out.println("Auth = "+request.getHeader("Authorization"));
        System.out.println("Method = "+request.getMethod());
        /*if("OPTIONS".equalsIgnoreCase(request.getMethod()))
        {
//        	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
//        	response.addHeader("Access-Control-Allow-Origin", "*");
        	//response.setStatus(HttpServletResponse.SC_OK);
        	
        	//response.setStatus(HttpServletResponse.SC_ACCEPTED);
            //return;
        	//chain.doFilter(req, res);
        } else {
            chain.doFilter(req, res);
        }*/
        
        if(path.equals("/lms/app/"))
        {
        	response.sendRedirect("./index.html");
        	return;
        }
        if(path.equals("/lms/app"))
        {
        	response.sendRedirect("./app/index.html");
        	return;
        }
        if(path.startsWith("/lms/login") || path.startsWith("/lms/test") || path.startsWith("/lms/angtest.html") || path.startsWith("/lms/app/")) {}
        else
        {
	        final String authHeader = request.getHeader("Authorization");
	        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	            //throw new ServletException("Missing or invalid Authorization header.");
	        	throw new AccessDeniedException("Missing or invalid Authorization header.");
	        	/*((HttpServletResponse)res).sendRedirect("/access-denied");
	        	chain.doFilter(req, res);*/
	        }
	
	        final String token = authHeader.substring(7); // The part after "Bearer "
	        //System.out.println("token = "+token);
	        try {
	            final Claims claims = Jwts.parser().setSigningKey("secretkey")
	                .parseClaimsJws(token).getBody();
	            request.setAttribute("claims", claims);
	        }
	        catch (final SignatureException e) {
	            //throw new ServletException("Invalid token.");
	        	throw new AccessDeniedException("Invalid token.");
	        }
        }
        chain.doFilter(req, res);
    }

}
