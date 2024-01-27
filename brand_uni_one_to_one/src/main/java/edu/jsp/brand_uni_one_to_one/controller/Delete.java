package edu.jsp.brand_uni_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.brand_uni_one_to_one.entity.Brand;
import edu.jsp.brand_uni_one_to_one.entity.Stores;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("brand_uni_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Brand brand = manager.find(Brand.class, 4);

		Stores stores = manager.find(Stores.class, 4);

		transaction.begin();
		manager.remove(stores);
		manager.remove(brand);
		transaction.commit();
		System.out.println("Deleted! ");
	}
}
