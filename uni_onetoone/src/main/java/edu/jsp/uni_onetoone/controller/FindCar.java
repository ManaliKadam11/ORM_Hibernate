package edu.jsp.uni_onetoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.uni_onetoone.entity.Car;
import edu.jsp.uni_onetoone.entity.Engine;

public class FindCar {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_onetoone");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Car car = manager.find(Car.class, 1);
		Engine engine = car.getEngine();

		System.out.println("--------Details of car are--------");
		System.out.println("Car id: "+ car.getCarid());
		System.out.println("Car model: "+ car.getModel());
		System.out.println("Car brand: "+ car.getBrand());
		System.out.println("Car cost: "+ car.getCost());
		
		System.out.println("--------Details of engine are--------");
		System.out.println("Engine id: "+ engine.getEngineid());
		System.out.println("Engine name: "+ engine.getName());
		System.out.println("Engine hp: "+ engine.getHp());

	}
}
