package com.iqmsoft.boot.backbone.service;

import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqmsoft.boot.backbone.model.Customer;
import com.iqmsoft.boot.backbone.model.Item;
import com.iqmsoft.boot.backbone.model.Location;
import com.iqmsoft.boot.backbone.model.Shipment;

@Service
public class MockService {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ShipmentService shipmentService;
	
	
	@PostConstruct
	public void createSomeObjects() {

		Location location = new Location();
		location.setStreet("123 Somewhere Street");
		location.setCity("Leawood");
		location.setState("KS");
		location.setZip("66209");

	    //	locationService.save(location);
		

	    // create a customer....

		Customer customer = new Customer();
		customer.setName("Test Customer");
		
	
		
		customer.setLocation(location);

		customerService.save(customer);

		// create another customer...

		customer = new Customer();
		customer.setName("Acme Corp");
		location = new Location();
		location.setStreet("123 Somewhere Street");
		location.setCity("Leawood");
		location.setState("KS");
		location.setZip("66209");
		
		customer.setLocation(location);

		customerService.save(customer);
		
		 customer = customerService.find(1l);

			Shipment shipment = new Shipment();
			shipment.setCustomer(customer);
			shipment.setShipmentDate(Calendar.getInstance());
			shipment = shipmentService.save(shipment);

			// create Item
			Item item = new Item();

			item.setDescription("Acme Widget");
			item.setQuantity(1.0f);
			item.setWidth(12.00f);
			item.setHeight(12.00f);
			item.setWeight(200.00f);

			shipment.getItems().add(item);

			shipmentService.save(shipment);
		

		
	}
}