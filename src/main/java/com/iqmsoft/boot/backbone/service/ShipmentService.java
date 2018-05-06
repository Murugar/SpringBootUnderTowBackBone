package com.iqmsoft.boot.backbone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqmsoft.boot.backbone.model.Item;
import com.iqmsoft.boot.backbone.model.Shipment;
import com.iqmsoft.boot.backbone.model.WeightAndSize;
import com.iqmsoft.boot.backbone.repository.ItemRepository;
import com.iqmsoft.boot.backbone.repository.ShipmentRepository;

@Service
public class ShipmentService {

	@Autowired
	ShipmentRepository repository;

	@Autowired
	ItemRepository itemRepository;

	public Shipment find(long id) {
		return repository.findOne(id);
	}

	public List<Shipment> findAll() {
		return (List<Shipment>)repository.findAll();
	}

	public Shipment save(Shipment shipment) {
		return repository.save(shipment);
	}

	public Item save(Item item) {
		return itemRepository.save(item);

	}
	
	public WeightAndSize shipmentWeightAndSize(long shipmentId) {


		double totalWeight = 0.0;
		double totalSize = 0.0;

		Shipment shipment = this.find(shipmentId);

		for (Item item : shipment.getItems()) {

			totalWeight += item.getWeight(); 
			totalSize += item.getHeight() * item.getWidth();
		}

		WeightAndSize weightAndSize = new WeightAndSize();
		weightAndSize.setShipmentId(shipmentId);
		weightAndSize.setSize(totalSize);
		weightAndSize.setWeight(totalWeight);

		return weightAndSize;
	}
	
	
	
	
	

}