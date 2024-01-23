package edu.jsp.uni_onetoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.uni_onetoone.entity.Car;
import edu.jsp.uni_onetoone.entity.Engine;

public class SaveCar {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_onetoone");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Engine engine = new Engine();
		engine.setEngineid(03);
		engine.setName("u51");
		engine.setHp(100.0);

		Car car = new Car();
		car.setBrand("Ertiga");
		car.setModel("az2");
		car.setCarid(3);
		car.setCost(100000.0);

		transaction.begin();
		manager.persist(engine);
		manager.persist(car);
		transaction.commit();

		System.out.println("Car Saved");
	}
}
