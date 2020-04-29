package com.revature.service;

import com.revature.beans.Customer;
import com.revature.util.FileStuff;
import com.revature.util.Roster;

public class Withdraw {
	
	public void widr(Customer a) {
		//a is going to Withdraw
		int amount = a.getAmount();
		int firstBalance = a.getBalance();
		a.setBalance(firstBalance - amount);
		FileStuff.writeCustomerFile(Roster.customerList);
	}

}
