package com.iqmsoft.boot.backbone.service;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iqmsoft.boot.backbone.SpringBootBackBone;
import com.iqmsoft.boot.backbone.model.Customer;
import com.iqmsoft.boot.backbone.model.Location;
import com.iqmsoft.boot.backbone.service.CustomerService;
import com.iqmsoft.boot.backbone.service.LocationService;

import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootBackBone.class)
public class CustomerServiceTest {

	@Autowired
	CustomerService service;

	@Autowired
	LocationService locationService;

	@Test
	public void insert() {

		Customer customer = new Customer();
		customer.setName("Test Company");
		// create and save a location

		Location location = new Location();
		location.setStreet("123 easy street");
		location.setCity("Somewhere");
		location.setState("KS");
		location.setZip("123456");

		//locationService.save(location);

		// set to customer

		customer.setLocation(location);

		// save customer

		customer = service.save(customer);

		// find by id

		customer = service.find(customer.getId());

		Assert.assertNotNull(customer);
	}
	
	
	@Test
	public void findall() {
		List<Customer> customer = service.findAll();
		Assert.assertFalse(customer.isEmpty());
	}
	
	
	
	
	
}