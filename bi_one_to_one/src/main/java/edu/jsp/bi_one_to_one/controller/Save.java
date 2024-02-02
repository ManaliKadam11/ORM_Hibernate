package edu.jsp.bi_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.bi_one_to_one.entity.Car;
import edu.jsp.bi_one_to_one.entity.Engine;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bi_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Car car = new Car();
		car.setBrand("Honda");
		car.setModel("city");
		car.setCarid(1);
		car.setCost(210000.0);

		Engine engine = new Engine();
		engine.setEngineid(01);
		engine.setName("h1");
		engine.setHp(101.0);

		car.setEngine(engine);
		engine.setCar(car);

		transaction.begin();
		manager.persist(engine);
		manager.persist(car);
		transaction.commit();

		System.out.println("Car Saved");
	}
}
