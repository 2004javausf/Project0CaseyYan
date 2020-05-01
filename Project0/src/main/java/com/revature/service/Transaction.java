package com.revature.service;

import java.util.Scanner;

import com.revature.beans.Account;

public class Transaction {
	
	public static void trans(Account a, Account b) {
		//a is going to transfer to b
		System.out.println("Please input the amount you want to transfer: ");
		Scanner sc = new Scanner(System.in);
		double amount = sc.nextDouble();
		sc.close();
		if(amount > a.getBalance()) {
			System.out.println("Insufficient funds for transfer.");
		}else {
			a.setBalance(a.getBalance() - amount);
			b.setBalance(b.getBalance() + amount);
		}
	}
	


}
