package com.revature.service;

import java.util.Scanner;

import com.revature.beans.Account;

public class Withdraw {

	public static void widr(Account a) {
		//a is going to Withdraw
		System.out.println("Please input the amount you wish to withdraw: ");
		Scanner sc = new Scanner(System.in);
		double amount = sc.nextDouble();
		sc.close();
		if(amount > a.getBalance()) {
			System.out.println("Insufficient funds. This account only has $" + a.getBalance());
		}
		else {
			a.setBalance(a.getBalance() - amount);
		}
	}

}
