package com.revature.menu;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.service.Deposit;
import com.revature.service.Transaction;
import com.revature.service.Withdraw;
import com.revature.util.FileStuff;

public class AdminMenu {
//	o	Approving/denying accounts
//	o	withdrawing, depositing, transferring from all accounts
//	o	canceling accounts
	static Scanner scan = new Scanner(System.in);
	
	public static void adminMenu(ArrayList<String> accountType, ArrayList<User> user, ArrayList<Account> account,
			int index) {
		
			int o = scan.nextInt();
			do {
				System.out.println("Please make a option:");
				System.out.println("1: Approve/Deny Application");
				System.out.println("2: View account information");
				System.out.println("3: Withdraw from an account");
				System.out.println("4: Deposit from an account");
				System.out.println("5: Transfer from an account");
				System.out.println("6: Cancel an acount");
				System.out.println("7: Exit");
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
					Scanner sc1 = new Scanner (System.in);
					System.out.println("Enter the index of the account you want to withdraw from: ");
					int withdraw = sc1.nextInt();
					Withdraw.widr(account.get(withdraw));
					System.out.println("Account Withdrawn. New balance: $"+ account.get(withdraw).getBalance());
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					FileStuff.writeFile(account, new File("AccountFile.txt"));
					sc1.close();
					break;
					
				case 4:
					Scanner sc2 = new Scanner (System.in);
					System.out.println("Enter the index of the account you want to deposit to: ");
					int deposit = sc2.nextInt();
					Deposit.depo(account.get(deposit));
					System.out.println("Account Deposited. New balance: $"+ account.get(deposit).getBalance());
					System.out.println("\n");
					System.out.println("=======================================================================================================");
					FileStuff.writeFile(account, new File("AccountFile.txt"));
					sc2.close();
					break;
					
				case 5:
					Scanner sc3 = new Scanner (System.in);
					System.out.println("Enter the index of the account you want to transfer from: ");
					int transFrom = sc3.nextInt();
					
					System.out.println("Enter the index of the account you want to transfer to: ");
					int transTo = sc3.nextInt();
					
					Transaction.trans(account.get(transFrom), account.get(transTo));
					System.out.println(user.get(transFrom).getName()+"'s balance is now $" + account.get(transFrom).getBalance());
					System.out.println(user.get(transTo).getName()+"'s balance is now $" + account.get(transTo).getBalance());
					System.out.println("=======================================================================================================");
					FileStuff.writeFile(account, new File("AccountFile.txt"));
					sc3.close();
					break;
					
				case 6:
					System.out.println("Please enter index of account to be cancelled.");
					Scanner s4 = new Scanner (System.in);
					int killIt = s4.nextInt();
					s4.close();
					if(killIt < 0 || killIt > account.size()) {
						System.out.println("Invalid input.");
					}else {
						System.out.println("The Customer's account has been canceled.");
						accountType.remove(killIt);
						user.remove(killIt);
						account.remove(killIt);
						FileStuff.writeFile(accountType, new File ("AccountTypeFile.txt"));
						FileStuff.writeFile(user, new File("UserFile.txt"));
						FileStuff.writeFile(account, new File("AccountFile.txt"));
					}

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
