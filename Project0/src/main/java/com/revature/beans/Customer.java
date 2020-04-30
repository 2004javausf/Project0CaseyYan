package com.revature.beans;

import java.io.Serializable;

public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5468406550368728941L;
	private String name;
	private String username;
	private String password;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}