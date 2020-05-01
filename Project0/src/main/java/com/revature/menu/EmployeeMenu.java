package com.revature.menu;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.FileStuff;

public class EmployeeMenu {
	
//	o	This includes, account information
//	o	Account balances
//	o	Personal information
//	    approve/deny open applications for accounts
	static Scanner scan = new Scanner(System.in);
	
	public static void employMenu(ArrayList<String> accountType, ArrayList<User> user, ArrayList<Account> account,
			int index) {
	
		
	int o = scan.nextInt();
	
	do {
		System.out.println("Please make a option:");
		System.out.println("1: Approve/Deny Application");
		System.out.println("2: View account information");
		System.out.println("3: Exit");
		o = scan.nextInt();
		switch(o) {
		case 1:
			ArrayList<User> pendingUser = new ArrayList<User>();
			ArrayList<Account> pendingAccount = new ArrayList<Account>();
			ArrayList<Integer> ind = new ArrayList<Integer>(); //holds the index for deletion purposes
			ArrayList<Integer> toRemove = new ArrayList<Integer>();
			for(int i = 0; i<account.size(); i++) {
				if (account.get(i).isApproved() == false) {
					pendingUser.add(user.get(i));
					pendingAccount.add(account.get(i));
					ind.add(i);
				}
			}
			for(int i = 0; i<pendingAccount.size(); i++) {
				System.out.println(pendingUser.get(i).getName() + " would like to apply for a new account.");
				System.out.println("Y to Approve, N to Deny, anything else to postpone.");
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine();
				if(input.equalsIgnoreCase("y")) {
					System.out.println("The account has been approved.");
					pendingAccount.get(i).setApproved(true);
				}else if(input.equalsIgnoreCase("n")){
					System.out.println("The account has been denied.");
					toRemove.add(ind.get(i));
				}else {
					System.out.println("The account has been skipped.");
				}
				sc.close();
			}
			while(toRemove.size() != 0) {
				int theCulling = ind.get(toRemove.size()-1);
				user.remove(theCulling);
				accountType.remove(theCulling);
				account.remove(theCulling);
				toRemove.remove(toRemove.size()-1);
			}
			FileStuff.writeFile(accountType, new File ("AccountTypeFile.txt"));
			FileStuff.writeFile(user, new File("UserFile.txt"));
			FileStuff.writeFile(account, new File("AccountFile.txt"));
			
			break;
		
		case 2:
			
			for(int i = 0; i<user.size(); i++) { // list every customer in the bank 
				if(accountType.get(i).equals("employee")) {
					System.out.println(i+":" +user.get(i).getName() + " has a username of " + user.get(i).getUsername() + " and has an account that has a balance of $" + account.get(i).getBalance() + ". Has the account been approved? " + account.get(i).isApproved());
				}
			}
			break;
		case 3:
			System.out.println("Thanks for using our services. ");
			System.out.println("\n");
			System.out.println("=======================================================================================================");
			break;
		default:
			System.out.println("Please make a option from 1-2.");
			break;
		}
	} while (o == 3);
	System.out.println("=======================================================================================================");
	System.out.println("Good bye!");
	System.out.println("\n");
	}

}
