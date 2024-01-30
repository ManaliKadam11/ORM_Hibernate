package edu.jsp.bank_uni_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.bank_uni_one_to_one.entity.Bank;
import edu.jsp.bank_uni_one_to_one.entity.Loan;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bank_uni_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Bank bank = manager.find(Bank.class, 2);
		bank.setAddress("Kurla");
		Loan loan = manager.find(Loan.class, 3);
		loan.setAmount(12345678);
		
		transaction.begin();
		manager.persist(bank);
		manager.persist(loan);
		transaction.commit();
		System.out.println("Updated!");
	}
}
