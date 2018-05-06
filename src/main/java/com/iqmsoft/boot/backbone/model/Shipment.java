package com.iqmsoft.boot.backbone.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="shipment")
public class Shipment {

	@Id
	@GeneratedValue
	@Column
	private long id;

	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Item> items = new ArrayList<Item>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;

	@Column(name="shipment_date")
	private Calendar shipmentDate;


	@ManyToOne(fetch = FetchType.EAGER)
	private Location location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Calendar getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Calendar shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
