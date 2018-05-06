package com.iqmsoft.boot.backbone.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.boot.backbone.model.Customer;
import com.iqmsoft.boot.backbone.service.CustomerService;

@RestController()
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@RequestMapping("all")
	public List<Customer> all() {
     	return service.findAll();
	}
	
	@RequestMapping("{id}")
	public Customer find(@PathVariable("id") long id) {

		return service.find(id);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Customer create(@RequestBody Customer customer) {
		Customer cust = service.save(customer);
		return cust;

	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody Customer update(@RequestBody Customer customer) {
		Customer cust = service.save(customer);
		return cust;

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody boolean delete(@RequestBody Customer customer) {
		  service.delete(customer);
		return true;

	}
	
	
	
	
	
	 // Convert a predefined exception to an HTTP Status code
//	  @ResponseStatus(value=HttpStatus.BAD_REQUEST,
//	                  reason="Data integrity violation")  // 409
//	  @ExceptionHandler(DataIntegrityViolationException.class)
	  public void conflict() {
	    // Nothing to do
	  }
	  
	  // Specify name of a specific view that will be used to display the error:
//	  @ExceptionHandler({SQLException.class,DataAccessException.class})
	  public String databaseError() {
	    // Nothing to do.  Returns the logical view name of an error page, passed
	    // to the view-resolver(s) in usual way.
	    // Note that the exception is NOT available to this view (it is not added
	    // to the model) but see "Extending ExceptionHandlerExceptionResolver"
	    // below.
	    return "databaseError";
	  }

	  // Total control - setup a model and return the view name yourself. Or
	  // consider subclassing ExceptionHandlerExceptionResolver (see below).
	  //@ExceptionHandler(Exception.class)
	  public ErrorInfo handleError(HttpServletRequest req, Exception ex) {
	    System.out.println("Request: " + req.getRequestURL() + " raised " + ex);

  
	    ErrorInfo info = new ErrorInfo();
	    info.error = ex.getMessage();
	    info.message = "Error, please contact tech support at this <a href='http://google.com'>link</a>";
	    info.url = req.getRequestURL().toString();
	    
	    return info;
	  }	
	
	
	private class ErrorInfo {
		
		public String message;
		public String error;
		public String url;
		
	}
	  
	

}