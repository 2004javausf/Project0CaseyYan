package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.service.ApproveApplication;
import com.revature.service.DenyApplication;
import com.revature.service.Deposit;
import com.revature.service.EmployeeLogin;
import com.revature.service.ShowApplications;
import com.revature.service.ShowExistAccount;
import com.revature.service.Transaction;
import com.revature.service.Withdraw;
import com.revature.util.Roster;

public class EmployeeMenu {
	
//	o	This includes, account information
//	o	Account balances
//	o	Personal information
//	    approve/deny open applications for accounts
	static Scanner scan = new Scanner(System.in);
	
	public static void employMenu() {
	
		static ShowApplications shapp = new ShowApplications();
		static EmployeeLogin eLogin = new EmployeeLogin();
		static ApproveApplication approve = new ApproveApplication();
		static DenyApplication deny = new DenyApplication();
		static ShowExistAccount showaccount = new ShowExistAccount();
	
	
	System.out.println("Enter employee username.");
	String username = scan.nextLine();
	System.out.println("Enter employee password");
	String password = scan.nextLine();
	int o = scan.nextInt();
	EmployeeLogin.eLogin(username, password); 
	
	do {
		System.out.println("Please make a option:");
		System.out.println("1: Approve/Deny Application");
		System.out.println("2: View account information");
		System.out.println("3: Exit");
		o = scan.nextInt();
		switch(o) {
		case 1:
			ShowApplications.shapp();
			System.out.println("Y for Approve" + "n/N for Deny");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if(input.equals("Y")) {
				System.out.println("Enter username to approve");
				username = sc.nextLine();
				ApproveApplication.approve(username);
				System.out.println("The Account has been approved");
				break;
			} else if(input.equals("N")) {
				System.out.println("Enter username to deny");
				username = sc.nextLine();
				DenyApplication.deny(username);
				System.out.println("The Account has been denied.");
				break;
			}
		
		case 2:
			ShowExistAccount.showaccount();
			break;
		case 3:
			System.out.println("Thanks for using our services. ");
			System.out.println("\n");
			System.out.println("=======================================================================================================");
			Menu.serviceMenu();
			break;
		default:
			System.out.println("Please make a option from 1-4.");
			Menu.serviceMenu();
			break;
		}
	} while (o !='3');
	System.out.println("=======================================================================================================");
	System.out.println("Good bye!");
	System.out.println("\n");
	}

}
