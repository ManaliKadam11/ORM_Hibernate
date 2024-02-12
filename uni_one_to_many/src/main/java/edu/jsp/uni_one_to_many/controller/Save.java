package edu.jsp.uni_one_to_many.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.uni_one_to_many.entity.Account;
import edu.jsp.uni_one_to_many.entity.Bank;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_one_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Bank bank1 = new Bank();
		bank1.setId(1);
		bank1.setName("ICICI");
		bank1.setIfsc("ICICI123");
		bank1.setBranch("Ghatkopar East");

		Bank bank2 = new Bank();
		bank2.setId(1);
		bank2.setName("ICICI");
		bank2.setIfsc("ICICI123");
		bank2.setBranch("Ghatkopar East");

		Account account = new Account();
		account.setId(101);
		account.setAcc_name("Manali");
		account.setAccountno(114567);
		account.setCreated(LocalDate.of(2000, 11, 11));

		Account account1 = new Account();
		account1.setId(101);
		account1.setAcc_name("Manali");
		account1.setAccountno(114567);
		account1.setCreated(LocalDate.of(2000, 11, 11));

		List<Account> accounts = new ArrayList<>();
		accounts.add(account);
		accounts.add(account1);

		bank1.setAccounts(accounts);

		transaction.begin();
		manager.persist(accounts);
		manager.persist(bank1);
		manager.persist(bank2);
		manager.persist(account);
		manager.persist(account1);
		transaction.commit();
	}
}
