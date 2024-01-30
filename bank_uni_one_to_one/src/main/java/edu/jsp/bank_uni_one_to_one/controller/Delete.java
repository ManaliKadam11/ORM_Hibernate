package edu.jsp.bank_uni_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.bank_uni_one_to_one.entity.Bank;
import edu.jsp.bank_uni_one_to_one.entity.Loan;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bank_uni_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Bank bank = manager.find(Bank.class, 2);

		Loan loan = manager.find(Loan.class, 2);

		transaction.begin();
		manager.remove(bank);
		manager.remove(loan);
		transaction.commit();
		System.out.println("Delete!");
	}
}
