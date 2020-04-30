package com.revature.service;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.util.FileStuff;
import com.revature.util.Roster;

public class Withdraw {
	
	private static int input2;

	public static void widr(User a) {
		//a is going to Withdraw
		System.out.println("Please input your withdraw amount: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
        input2 += amount;
		int firstBalance = a.getBalance();
		a.setBalance(firstBalance - amount);
		FileStuff.writeCustomerFile(Roster.customerList);
	}

	public int getAmount2() {
		return input2;
	}

}
