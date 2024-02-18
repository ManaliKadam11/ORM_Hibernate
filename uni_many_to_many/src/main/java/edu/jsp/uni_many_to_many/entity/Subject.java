package edu.jsp.uni_many_to_many.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	private int id;
	private String name;
	private String code;
	private int duration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Subject() {
		super();
	}

}
