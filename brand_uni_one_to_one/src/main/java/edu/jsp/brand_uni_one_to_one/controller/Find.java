package edu.jsp.brand_uni_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.brand_uni_one_to_one.entity.Brand;
import edu.jsp.brand_uni_one_to_one.entity.Stores;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("brand_uni_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Brand brand = manager.find(Brand.class, 2);
		System.out.println("------Details of Brand-----");
		System.out.println("Brand id: " + brand.getBrandid());
		System.out.println("Brand name: " + brand.getBrandname());
		System.out.println("Brand Logo color: " + brand.getLogocolor());
		System.out.println("Brand Rate: " + brand.getRate());

		Stores stores = manager.find(Stores.class, 2);
		System.out.println("------Details of Store-----");
		System.out.println("Stores id: " + stores.getId());
		System.out.println("Stores Location: " + stores.getLocation());
		System.out.println("Stores Producat availability: " + stores.getProductavailability());
		System.out.println("Stores Cost: " + stores.getStorecost());

		transaction.begin();
		manager.persist(brand);
		manager.persist(stores);
		transaction.commit();
	}
}
