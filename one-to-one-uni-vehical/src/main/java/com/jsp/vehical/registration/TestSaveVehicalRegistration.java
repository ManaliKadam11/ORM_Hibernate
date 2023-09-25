package com.jsp.vehical.registration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveVehicalRegistration {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manali");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Vehical vehical = new Vehical();
		vehical.setBrand("Honda");
		vehical.setColor("Blue");
		vehical.setName("SP");
		vehical.setPrice(86000);
		
		Registration registration = new Registration();
		registration.setCity("Delhi");
		registration.setRegistationNo(9876);
		registration.setVehical(vehical);

		entityTransaction.begin();
		entityManager.persist(vehical);
		entityManager.persist(registration);
		entityTransaction.commit();
	}
}

