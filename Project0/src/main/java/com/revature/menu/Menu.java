package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.service.Deposit;
import com.revature.service.Transaction;
import com.revature.service.Withdraw;
import com.revature.util.Roster;

public class Menu {
	
	static Deposit depo = new Deposit();
	static Transaction trans = new Transaction();
	static Withdraw widr = new Withdraw();
	
	static Scanner scan = new Scanner(System.in);
	
	public static void startMenu() {
		System.out.println("Welcome to Our Menu!");
		System.out.println("Please enter a choice:");
		System.out.println("[R]egister a new account");
		System.out.println("[S]ervice");
		System.out.println("[E]xit");
		String choice = scan.nextLine();
		switch(choice.toLowerCase()) {
		    case "r":
		    	createMenu();
		    	break;
		    case "s":
		    	serviceMenu();
		    	break;
		    case "e":
		        System.out.println("Thanks for being our customer. ");
		        break;
		    default:
		        System.out.println("Try again.");
		        startMenu();
		        break;
		}
	}
	
	
	public static void createMenu() {
		System.out.println("Register a new Account!");
		
		System.out.println("Please enter your name: ");
		String customerName = scan.nextLine();
		
		System.out.println("Please enter your ID: ");
		String customerId = scan.nextLine();
		
		System.out.println("Please enter your first Deposit: ");
		int customerBalance = Integer.parseInt(scan.nextLine());
		
		new Customer(customerName,customerId,customerBalance);
		
//		Customer a = new Customer(customerName,customerId,customerBalance);
//		customerList.add(a);
//		writeToFile(customerFile, customerList);
		
		new Customer(customerName,customerId,customerBalance);
		
		System.out.println(Roster.customerList.toString());
		
		System.out.println("Would you like to make a new Account? (y/n)");
		String choice=scan.nextLine();
		if(choice.equalsIgnoreCase("y")) {
			createMenu();
		}else if(choice.equalsIgnoreCase("n")) {
			startMenu();
		}else {
			System.out.println("Too bad, you are going back to the main menu.");
			startMenu();
		}
	}
	
	public static void serviceMenu() {
		//==============================
		System.out.println("Enter your login in ID: ");
		String first = scan.nextLine();
		Customer a= Roster.findCustomerById(first);
		
		
		char option = '\0';
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to use our Banking App. Dear " + a.getName() + "!");
		System.out.println("Your account number is " + a.getId());
		System.out.println("=======================================================================================================");
		System.out.println("1. Check Balance.");
		System.out.println("2. Deposit.");
		System.out.println("3. Withdraw.");
		System.out.println("4. Transfer.");
		System.out.println("5. Exit.");
		
		do {
			System.out.println("=======================================================================================================");
			System.out.println("Please make a option: ");
			option = sc.next().charAt(0);
			System.out.println("=======================================================================================================");
			System.out.println("\n");
			
			switch(option) {
			
			case '1':
				System.out.println("Your current balances are: "+ a.getBalance());
				System.out.println("\n");
				System.out.println("=======================================================================================================");
				serviceMenu();
				break;
				
			case '2':

				Deposit.depo(a);
				Deposit d = new Deposit();
				int amount1 = d.getAmount1();
				System.out.println("Your deposit amounts are: "+ Math.abs(amount1));
				System.out.println("Your current balances are: "+ a.getBalance());
				System.out.println("\n");
				System.out.println("=======================================================================================================");
				serviceMenu();
				break;
				
			case '3':

				Withdraw.widr(a);
				Withdraw w = new Withdraw();
				int amount2 = w.getAmount2();
				System.out.println("Your withdraw amounts are: "+ Math.abs(amount2));
				System.out.println("Your current balances are: "+ a.getBalance());
				System.out.println("\n");
				System.out.println("=======================================================================================================");
				serviceMenu();
				break;
				
			case '4':
				System.out.println("Enter the ID of you transfer to: ");
				String second = scan.nextLine();
				Customer b = Roster.findCustomerById(second);
				System.out.println("Find the correct Customer ID!");
				Transaction.trans(a, b);
				Transaction t = new Transaction();
				int amount3 = t.getAmount3();
				System.out.println(a.getName()+" just transfered " + amount3 + " to Customer "+b.getName());
				System.out.println(a.getName()+" 's balance is now " + a.getBalance());
				System.out.println(b.getName()+" 's HP is now " + b.getBalance());
				System.out.println("=======================================================================================================");
				serviceMenu();
				break;
				
			case '5':

				System.out.println("Thanks for using our services. ");
				System.out.println("\n");
				System.out.println("=======================================================================================================");
				serviceMenu();
				break;
			
			default:
				System.out.println("Please make a option from 1-4.");
				serviceMenu();
				break;
			}
			     
		} while (option !='5');
		System.out.println("=======================================================================================================");
		System.out.println("Good bye!");
		System.out.println("\n");
		
	}

}
