package com.rohan.lms.controller;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ErrorController {
	
	/*@RequestMapping(value="/test_ex", method=RequestMethod.GET)
	public ModelAndView testEx() throws Exception
	{
		//throw new IOException("you raised an io exception");
		
		throw new SQLException("you raised an SQL exception");
		
		//return new ModelAndView(new RedirectView("/",true));
	}*/
	
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOEx(IOException iox)
	{
		System.out.println(iox.getMessage());
		return new ModelAndView("error/io_ex");
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public @ResponseBody String handleADEx(AccessDeniedException iox)
	{
		System.out.println(iox.getMessage());
		return "Access is denied";
	}
	
	/*@ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleResourceNotFoundException(NoHandlerFoundException ex) {
		return new ModelAndView("404");
    }*/
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleIOEx(Exception iox)
	{
		System.out.println(iox.getMessage());
		return new ModelAndView("error/error");
	}
}
