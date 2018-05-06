package com.iqmsoft.boot.backbone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.boot.backbone.model.Location;
import com.iqmsoft.boot.backbone.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	LocationRepository repository;

	public List<Location> findAll() {
		return (List<Location>) repository.findAll();
	}

	@Transactional
	public void save(Location location) {

		repository.save(location);
		
	}
}