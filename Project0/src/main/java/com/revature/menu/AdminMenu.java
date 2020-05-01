package com.revature.menu;

import java.util.ArrayList;
import java.util.Scanner;

<<<<<<< HEAD
import com.revature.beans.Customer;
=======
import com.revature.beans.Account;
import com.revature.beans.User;
>>>>>>> 6afc140257aa509e194df39086cbbdaf26e25473
import com.revature.service.AdminLogin;
import com.revature.service.ApproveApplication;
import com.revature.service.CancelAccount;
import com.revature.service.DenyApplication;
import com.revature.service.Deposit;
import com.revature.service.EmployeeLogin;
import com.revature.service.ShowApplications;
import com.revature.service.ShowExistAccount;
import com.revature.service.Transaction;
import com.revature.service.Withdraw;
import com.revature.util.Roster;
import com.revature.beans.;

public class AdminMenu {
//	o	Approving/denying accounts
//	o	withdrawing, depositing, transferring from all accounts
//	o	canceling accounts
	static Scanner scan = new Scanner(System.in);
	Customer a= Roster.findCustomerById(first);
	
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
					Scanner sc1 = new Scanner (System.in);
					System.out.println("Enter the ID you withdraw from: ");
					String withdraw = sc1.nextLine();
					Customer a = Roster.findCustomerById(withdraw);
					System.out.println("Find the correct Customer ID!");
					Withdraw.widr(a);
					Withdraw w = new Withdraw();
					int amount2 = w.getAmount2();
					System.out.println("The deposit amounts are: "+ Math.abs(amount2));
					System.out.println("The Customer current balances are: "+ a.getBalance());
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					break;
					
				case 4:
					Scanner sc2 = new Scanner (System.in);
					System.out.println("Enter the ID you deposit to: ");
					String deposit = sc2.nextLine();
					Customer b = Roster.findCustomerById(deposit);
					System.out.println("Find the correct Customer ID!");
					Deposit.depo(b);
					Deposit d = new Deposit();
					int amount1 = d.getAmount1();
					System.out.println("The deposit amounts are: "+ Math.abs(amount1));
					System.out.println("The Customer current balances are: "+ a.getBalance());
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					System.out.println("=======================================================================================================");
					break;
					
				case 5:
					Scanner sc3 = new Scanner (System.in);
					System.out.println("Enter the ID you transfer from: ");
					String transfrom = sc3.nextLine();
					Customer c = Roster.findCustomerById(transfrom);
					System.out.println("Find the correct Customer ID!");
					
					Scanner sc4 = new Scanner (System.in);
					System.out.println("Enter the ID you transfer to: ");
					String transto = sc4.nextLine();
					Customer e = Roster.findCustomerById(transto);
					System.out.println("Find the correct Customer ID!");
					
					Transaction.trans(a, b);
					Transaction t = new Transaction();
					int amount3 = t.getAmount3();
					System.out.println(a.getName()+" just transfered " + amount3 + " to Customer "+b.getName());
					System.out.println(a.getName()+" 's balance is now " + a.getBalance());
					System.out.println(b.getName()+" 's balance is now " + b.getBalance());
					System.out.println("=======================================================================================================");
					break;
					
				case 6:
					CancelAccount.cancel(a);
					System.out.println("The Customer's account has been canceled. ");
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					break;
					
				case 7:
					System.out.println("Thanks for using our services. ");
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					break;
					
				default:
					System.out.println("Please make a option from 1-4.");
					break;
				}
			} while (o == 7);
			System.out.println("=======================================================================================================");
			System.out.println("Good bye!");
			System.out.println("\n");
			}


}
