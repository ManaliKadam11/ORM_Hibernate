package edu.jsp.brand_uni_one_to_one.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stores {
	@Id
	private int id;
	private String location;
	private String productavailability;
	private int storecost;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProductavailability() {
		return productavailability;
	}

	public void setProductavailability(String productavailability) {
		this.productavailability = productavailability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStorecost() {
		return storecost;
	}

	public void setStorecost(int storecost) {
		this.storecost = storecost;
	}

	public Stores() {
		super();
	}

}
