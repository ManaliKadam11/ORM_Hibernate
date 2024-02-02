package edu.jsp.bi_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.bi_one_to_one.entity.Car;
import edu.jsp.bi_one_to_one.entity.Engine;



public class Update {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bi_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Car car = manager.find(Car.class, 1);
		Engine engine = manager.find(Engine.class, 1);

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
