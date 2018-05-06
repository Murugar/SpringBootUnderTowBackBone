package com.iqmsoft.boot.backbone.service;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iqmsoft.boot.backbone.SpringBootBackBone;
import com.iqmsoft.boot.backbone.model.Customer;
import com.iqmsoft.boot.backbone.model.Item;
import com.iqmsoft.boot.backbone.model.Shipment;
import com.iqmsoft.boot.backbone.service.CustomerService;
import com.iqmsoft.boot.backbone.service.ShipmentService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootBackBone.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShipmentServiceTest {

	@Autowired
	ShipmentService service;

	@Autowired
	CustomerService customerService;


	@Test
	public void testCreate() {

		Customer customer = customerService.find(1l);

		Shipment shipment = new Shipment();
		shipment.setCustomer(customer);
		shipment.setShipmentDate(Calendar.getInstance());
		shipment = service.save(shipment);

		// create Item
		Item item = new Item();

		item.setDescription("Acme Widget");
		item.setQuantity(1.0f);
		item.setWidth(12.00f);
		item.setHeight(12.00f);
		item.setWeight(200.00f);

		shipment.getItems().add(item);

		service.save(shipment);

		shipment = service.find(1);

		System.out.println(shipment.getItems());

	}

}