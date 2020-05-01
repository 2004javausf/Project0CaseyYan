package com.revature.service;

import java.util.Scanner;

import com.revature.beans.Account;

public class Deposit {
	
	public static void depo(Account a) {
		//a is going to deposit
		System.out.println("This account currently has $" + a.getBalance());
		System.out.println("Please input your deposit amount: ");
		Scanner sc = new Scanner(System.in);
		double amount = sc.nextDouble();
		sc.close();
		a.setBalance(a.getBalance() + amount);
	}	
	
}
