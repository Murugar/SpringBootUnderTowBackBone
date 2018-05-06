package com.iqmsoft.boot.backbone.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	public Customer() {
	}

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private Location location;

	
	@Column(name = "name")
	private String name;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
