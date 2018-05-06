package com.iqmsoft.boot.backbone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.boot.backbone.model.Customer;
import com.iqmsoft.boot.backbone.repository.CustomerRepository;
import com.iqmsoft.boot.backbone.repository.LocationRepository;

@Service
public class CustomerService {


	@Value("${version}")
    String token;
	
	@Autowired
	CustomerRepository repository;
    
	@Autowired
	LocationRepository locationRepository;
	
	public List<Customer> findAll() {
		return (List<Customer>) repository.findAll();
	}

	@Transactional
	public Customer save(Customer customer) {

		return repository.save(customer);
	}

	@Transactional
	public void delete(Customer customer) {

		repository.delete(customer);
	}

	public Customer find(Long id) {
		return repository.findOne(id);
	}

	public Customer findByName(String name) {

		return repository.findByName(name);

	}

}