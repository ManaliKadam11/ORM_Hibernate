package edu.jsp.uni_onetoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.uni_onetoone.entity.Car;
import edu.jsp.uni_onetoone.entity.Engine;

public class DeleteCar {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_onetoone");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Car car = manager.find(Car.class, 3);

		Engine engine = manager.find(Engine.class, 3);

		transaction.begin();
		manager.persist(car);
		manager.remove(engine);
		transaction.commit();
		System.out.println("Car Deleted");
		System.out.println("Engine Deleted");
	}
}
