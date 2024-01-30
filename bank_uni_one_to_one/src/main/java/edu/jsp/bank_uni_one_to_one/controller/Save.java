package edu.jsp.bank_uni_one_to_one.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.bank_uni_one_to_one.entity.Bank;
import edu.jsp.bank_uni_one_to_one.entity.Loan;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bank_uni_one_to_one");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Bank bank = new Bank();
		bank.setBankid(3);
		bank.setBankname("SBI");
		bank.setAddress("Vashi");
		
		Loan loan =new Loan();
		loan.setId(3);
		loan.setAccountno(91011);
		loan.setAmount(50000);
		
		transaction.begin();
		manager.persist(bank);
		manager.persist(loan);
		transaction.commit();
		System.out.println("Saved!");
	}
}
