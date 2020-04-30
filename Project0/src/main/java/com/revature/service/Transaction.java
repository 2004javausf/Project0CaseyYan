package com.revature.service;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.util.FileStuff;
import com.revature.util.Roster;

public class Transaction {
	
	private static int input3;
	
	public static void trans(Customer a, Customer b) {
		//a is going to transfer to b
		System.out.println("Please input your transfer amount: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
        input3 += amount;
		int firstBalance = a.getBalance();
		int secondBalance = b.getBalance();
		a.setBalance(firstBalance - amount);
		b.setBalance(secondBalance + amount);
		FileStuff.writeCustomerFile();
	}
	
	public int getAmount3() {
		// TODO Auto-generated method stub
		return input3;
	}


}
