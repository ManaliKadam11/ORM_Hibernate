package edu.jsp.uni_one_to_many.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.uni_one_to_many.entity.Account;
import edu.jsp.uni_one_to_many.entity.Bank;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_one_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Bank bank = manager.find(Bank.class, 1);
		List<Account> accounts = bank.getAccounts();

		for (Account account : accounts) {
			if (account.getId() == 102) {
				transaction.begin();
				account.setAcc_name("Manali Kadam");
				manager.merge(account);
				transaction.commit();
				System.out.println("Updated!");
			}
		}
	}
}
