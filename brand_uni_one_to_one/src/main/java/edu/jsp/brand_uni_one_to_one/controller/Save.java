package edu.jsp.brand_uni_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.brand_uni_one_to_one.entity.Brand;
import edu.jsp.brand_uni_one_to_one.entity.Stores;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("brand_uni_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Brand brand = new Brand();
		brand.setBrandid(5);
		brand.setBrandname("Shopperstop");
		brand.setLogocolor("Black");
		brand.setRate(1000000);

		Stores stores = new Stores();
		stores.setId(5);
		stores.setLocation("Kurla");
		stores.setProductavailability("available");
		stores.setStorecost(100000);

		transaction.begin();
		manager.persist(brand);
		manager.persist(stores);
		transaction.commit();

		System.out.println("Saved successfully!");
	}
}
