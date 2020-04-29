package com.revature.service;

import com.revature.beans.Customer;
import com.revature.util.FileStuff;
import com.revature.util.Roster;

public class Transaction {
	
	public void transaction(Customer a, Customer b) {
		//a is going to hit b
		int transaction = a.getAmount();
		int firstBalance = a.getBalance();
		int secondBalance = b.getBalance();
		a.setBalance(firstBalance - transaction);
		b.setBalance(secondBalance + transaction);
		FileStuff.writeCustomerFile(Roster.customerList);
	}	

}
