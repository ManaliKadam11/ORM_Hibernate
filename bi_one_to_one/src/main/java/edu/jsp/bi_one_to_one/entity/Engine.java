package edu.jsp.bi_one_to_one.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Engine {
	@Id
	private int engineid;
	private String name;
	private double hp;

	@OneToOne(mappedBy = "engine")
	private Car car;

	public int getEngineid() {
		return engineid;
	}

	public void setEngineid(int engineid) {
		this.engineid = engineid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Engine() {
		super();
	}

}
