package com.jsp.person.account;

import java.util.ArrayList;

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
		person.setName("Manali");
		person.setEmail("manali@gmail.com");
		person.setGender("Female");
		person.setCno(123456789);
		
		Account account = new Account();
		account.setAcc_no(12367237);
		account.setBank_name("RBI");
		account.setIfsc_code("RBI123");
		
		Account account1 = new Account();
		account1.setAcc_no(34567898);
		account1.setBank_name("HDFC");
		account1.setIfsc_code("HDFC9876");
		
		Account account2 = new Account();
		account2.setAcc_no(987765345);
		account2.setBank_name("SBI");
		account2.setIfsc_code("SBI765");
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(account);
		accounts.add(account1);
		accounts.add(account2);
		
		//set a person with multiple banks accounts
		person.setAccounts(accounts);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(account);
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityTransaction.commit();
	}
}
