package com.revature.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.service.AdminLogin;
import com.revature.service.ApproveApplication;
import com.revature.service.DenyApplication;
import com.revature.service.Deposit;
import com.revature.service.EmployeeLogin;
import com.revature.service.ShowApplications;
import com.revature.service.ShowExistAccount;
import com.revature.service.Transaction;
import com.revature.service.Withdraw;

public class AdminMenu {
//	o	Approving/denying accounts
//	o	withdrawing, depositing, transferring from all accounts
//	o	canceling accounts
	static Scanner scan = new Scanner(System.in);
	
	public static void adminMenu(ArrayList<String> accountType, ArrayList<User> user, ArrayList<Account> account,
			int index) {
		ShowApplications shapp = new ShowApplications();
		AdminLogin aLogin = new AdminLogin();
		ApproveApplication approve = new ApproveApplication();
		DenyApplication deny = new DenyApplication();
		ShowExistAccount showaccount = new ShowExistAccount();
		
			System.out.println("Enter Admin username.");
			String username = scan.nextLine();
			System.out.println("Enter Admin password");
			String password = scan.nextLine();
			int o = scan.nextInt();
			AdminLogin.aLogin(username, password);
			do {
				System.out.println("Please make a option:");
				System.out.println("1: Approve/Deny Application");
				System.out.println("2: View account information");
				System.out.println("3: Withdraw from an account");
				System.out.println("4: Deposit from an account");
				System.out.println("5: Transfer from an account");
				System.out.println("6: cancel an acount");
				System.out.println("7: Exit");
				o = scan.nextInt();
				switch(o) {
				case 1:
					Employee.showApplications();
					System.out.println("Y for Approve" + "n/N for Deny");
					Scanner sc = new Scanner(System.in);
					String input = sc.nextLine();
					if(input.equals("Y")) {
						System.out.println("Enter username to approve");
						username = sc.nextLine();
						a.approveApplication(username);
						System.out.println("The Account has been approved");
						break;
					} else if(input.equals("N")) {
						System.out.println("Enter username to deny");
						username = sc.nextLine();
						a.denyApplication(username);
						System.out.println("The Account has been denied.");
						break;
					}
				
				case 2:
					ShowExistAccount.showAcc();
					break;
				case 3:
					System.out.println("Thanks for using our services. ");
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					Menu.serviceMenu();
					break;
				case 4:
					System.out.println("Thanks for using our services. ");
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					Menu.serviceMenu();
					break;
				case 5:
					System.out.println("Thanks for using our services. ");
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					Menu.serviceMenu();
					break;
				case 6:
					System.out.println("Thanks for using our services. ");
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					Menu.serviceMenu();
					break;
				case 7:
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
			} while (o !='7');
			System.out.println("=======================================================================================================");
			System.out.println("Good bye!");
			System.out.println("\n");
			}


}
