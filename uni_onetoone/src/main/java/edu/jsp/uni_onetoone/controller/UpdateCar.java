package edu.jsp.uni_onetoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.uni_onetoone.entity.Car;
import edu.jsp.uni_onetoone.entity.Engine;

public class UpdateCar {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_onetoone");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Car car = manager.find(Car.class, 2);
		Engine engine = manager.find(Engine.class, 3);

		car.setCost(2000000);

		engine.setName("BW101");

		transaction.begin();
		manager.persist(car);
		manager.persist(engine);
		transaction.commit();

		System.out.println("Car Updated");
		System.out.println("Engine Updated");

	}
}
