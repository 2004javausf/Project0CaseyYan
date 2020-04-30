package com.revature.service;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.util.FileStuff;
import com.revature.util.Roster;

public class Deposit {
	
	private static int input1;
	
	public static void depo(User a) {
		//a is going to deposit
		System.out.println("Please input your deposite amount: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
        input1 += amount;
		int firstBalance = a.getBalance();
		a.setBalance(firstBalance + amount);
		FileStuff.writeCustomerFile(Roster.customerList);
	}	
	
    public int getAmount1() {
		return input1;
   }

}
