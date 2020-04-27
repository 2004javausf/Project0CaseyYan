package com.revature.account;

import java.util.Scanner;

public class Customer {
	
	String name;
	String id;
	int balance;
	int previousTransaction;


	public Customer(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	void deposit(int transaction) {
		if(transaction != 0) {
			balance = balance + transaction;
			previousTransaction = transaction;
		}
	}
	
	void withdraw(int transaction) {
		if (transaction != 0) {
			balance = balance - transaction;
			previousTransaction = -transaction;
		}
	}
	
	void history() {
		if (previousTransaction > 0) {
			System.out.println("The Customer Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("The Customer Withdraw: " + Math.abs(previousTransaction));
		} else {
			System.out.println("There is not transaction.");
		}	
	}
	
	public void customerPlatform() {
		
		char option = '\0';
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to use our Banking App. Dear " + name + "!");
		System.out.println("Your account number is " + id);
		System.out.println("=======================================================================================================");
		System.out.println("1. Check Balance.");
		System.out.println("2. Deposit.");
		System.out.println("3. Withdraw.");
		System.out.println("4. History.");
		System.out.println("5. Exit.");
		
		do {
			System.out.println("=======================================================================================================");
			System.out.println("Please make a option: ");
			option = sc.next().charAt(0);
			System.out.println("=======================================================================================================");
			System.out.println("\n");
			
			switch(option) {
			
			case '1':
				System.out.println("Your current balance are: "+ balance);
				System.out.println("=======================================================================================================");
				System.out.println("\n");
				break;
				
			case '2':
				System.out.println("=======================================================================================================");
				System.out.println("Please input your deposite amount: ");
				int depo = sc.nextInt();
				deposit(depo);
				System.out.println("Your deposit amounts are: "+ depo);
				System.out.println("\n");
				break;
				
			case '3':
				System.out.println("=======================================================================================================");
				System.out.println("Please input your withdraw amount: ");
				int widr = sc.nextInt();
				withdraw(widr);
				System.out.println("Your withdraw amounts are: "+ Math.abs(widr));
				System.out.println("\n");
				break;
				
			case '4':
				System.out.println("=======================================================================================================");
				history();
				System.out.println("\n");
				break;
				
			case '5':
				System.out.println("=======================================================================================================");
				System.out.println("Thanks for using our services. ");
				System.out.println("\n");
				break;
			
			default:
				System.out.println("Please make a option from 1-5.");
				break;
			}
			     
		} while (option !='5');
		System.out.println("=======================================================================================================");
		System.out.println("Good bye!");
		System.out.println("\n");
		
	}
	
	

}
