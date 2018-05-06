package com.iqmsoft.boot.backbone.controller;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice 
class GlobalDefaultExceptionHandler {
 

	private final static Logger logger = Logger
            .getLogger(GlobalDefaultExceptionHandler.class
                    .getName());
	
	public static final String DEFAULT_ERROR_VIEW = "error"; 
	
	
  @ExceptionHandler(value = RuntimeException.class)
  @ResponseStatus(value=HttpStatus.BAD_REQUEST,
  reason="Some Exception has Occurred") 
  public ModelAndView
  defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    
	  logger.log(Level.SEVERE,"Global Exception Occured", e);
	  ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

      mav.addObject("datetime", new Date());
      mav.addObject("GLOBAL exception", e);
      mav.addObject("url", req.getRequestURL());
      return mav;
	    
  
  }
  
  
  
  
}
