package com.revature.beans;

import java.io.Serializable;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -498284351838735069L;
	private double balance;
	private boolean approved;
	
	public Account(double balance, boolean approved) {
		super();
		this.balance = balance;
		this.approved = approved;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", approved=" + approved + "]";
	}

	
}
