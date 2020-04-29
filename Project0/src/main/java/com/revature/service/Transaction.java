package com.revature.service;

import com.revature.beans.Customer;
import com.revature.util.FileStuff;
import com.revature.util.Roster;

public class Transaction {
	
	public void trans(Customer a, Customer b) {
		//a is going to transfer to b
		int amount = a.getAmount();
		int firstBalance = a.getBalance();
		int secondBalance = b.getBalance();
		a.setBalance(firstBalance - amount);
		b.setBalance(secondBalance + amount);
		FileStuff.writeCustomerFile(Roster.customerList);
	}	

}
