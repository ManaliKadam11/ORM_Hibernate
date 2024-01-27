package edu.jsp.brand_uni_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.brand_uni_one_to_one.entity.Brand;
import edu.jsp.brand_uni_one_to_one.entity.Stores;

public class Update {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("brand_uni_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Brand brand =manager.find(Brand.class, 5);
		brand.setLogocolor("Black-White");
		
		
		Stores stores=manager.find(Stores.class, 5);
		stores.setProductavailability("Not-available");
		
		
		transaction.begin();
		manager.persist(brand);
		manager.persist(stores);
		transaction.commit();
		
		System.out.println("Updated! ");
	}
}