package com.bank.account;

public class Customer {

	private String name;
	private String address;
	private String username;
	private String password;
	
	public Customer(String name, String address, String username, String password) {
		super();
		this.name = name;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", username=" + username + ", password=" + password
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
}
