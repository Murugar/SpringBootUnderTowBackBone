package com.iqmsoft.boot.backbone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.boot.backbone.model.Shipment;
import com.iqmsoft.boot.backbone.model.WeightAndSize;
import com.iqmsoft.boot.backbone.service.ShipmentService;

@RestController()
@RequestMapping("shipment")
public class ShipmentController {

	@Autowired
	ShipmentService service;

	@RequestMapping("all")
	public List<Shipment> all() {

		return service.findAll();
	}

	@RequestMapping("{id}")
	public Shipment find(@PathVariable("id") long id) {

		return service.find(id);

	}


	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Shipment create(@RequestBody Shipment shipment) {
		Shipment ship = service.save(shipment);
		return ship;

	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody Shipment update(@RequestBody Shipment shipment) {
		Shipment ship = service.save(shipment);
		return ship;

	}
	
	@RequestMapping("/weightsize/{id}")
	public WeightAndSize weightAndSize (@PathVariable("id") long shipmentId)     {
	  return service.shipmentWeightAndSize(shipmentId);
	}
	
	
	
	

}