package edu.jsp.bank_uni_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.bank_uni_one_to_one.entity.Bank;
import edu.jsp.bank_uni_one_to_one.entity.Loan;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bank_uni_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Bank bank = manager.find(Bank.class, 1);
		System.out.println("------Details of Bank-----");
		System.out.println("Bank id: " + bank.getBankid());
		System.out.println("Bank name: " + bank.getBankname());
		System.out.println("Bank Address: " + bank.getAddress());

		Loan loan = manager.find(Loan.class, 1);
		System.out.println("------Details of Loan-----");
		System.out.println("Loan id: " + loan.getId());
		System.out.println("Loan amount: " + loan.getAmount());
		System.out.println("Loan account no: " + loan.getAccountno());

		transaction.begin();
		manager.persist(loan);
		manager.persist(bank);
		transaction.commit();
	}
}
