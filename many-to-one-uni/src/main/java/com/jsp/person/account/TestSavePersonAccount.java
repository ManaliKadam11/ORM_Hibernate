package com.jsp.person.account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonAccount {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manali");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	Person person = new Person();
	person.setName("Kanishk");
	person.setGender("Female");
	person.setCno(8765349);
	
	Account account = new Account();
	account.setAcc_no(1232132221);
	account.setBank_name("SBI");
	account.setIfsc_code("SBI12345");
	
	Account account1 = new Account();
	account1.setAcc_no(764567845);
	account1.setBank_name("HDFC");
	account1.setIfsc_code("HDFC98767");
	
	Account account2 = new Account();
	account2.setAcc_no(98753356);
	account2.setBank_name("UNION");
	account2.setIfsc_code("UNI87546");
	
	account.setPerson(person);
	account1.setPerson(person);
	account2.setPerson(person);
	
	entityTransaction.begin();
	entityManager.persist(person);
	entityManager.persist(account);
	entityManager.persist(account1);
	entityManager.persist(account2);
	entityTransaction.commit();
}
}
