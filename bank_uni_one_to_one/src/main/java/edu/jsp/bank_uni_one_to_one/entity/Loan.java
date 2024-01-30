package edu.jsp.bank_uni_one_to_one.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loan {
	@Id
	private int id;
	private int amount;
	private int accountno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public Loan() {
		super();
	}

}
