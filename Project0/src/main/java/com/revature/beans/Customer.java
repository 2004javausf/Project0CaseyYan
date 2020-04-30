package com.revature.beans;

import java.io.Serializable;

public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5468406550368728941L;
	private String name;
	private String id;
	private int balance;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String id, int balance) {
		super();
		this.name = name;
		this.id = id;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", balance=" + balance + "]";
	}

	
	
	
	

}
