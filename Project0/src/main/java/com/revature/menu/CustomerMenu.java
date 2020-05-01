package com.revature.menu;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.driver.StartMenu;
import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.service.Deposit;
import com.revature.service.Transaction;
import com.revature.service.Withdraw;
import com.revature.util.FileStuff;

public class CustomerMenu {

	public static void serviceMenu(ArrayList<String> accountType, ArrayList<User> user, ArrayList<Account> account,
			int index) {


		ArrayList<Account> userOwned = new ArrayList<Account>();
		for (int i = 0; i < user.size(); i++) {// create an array of all owned accounts
			if (user.get(i).equals(user.get(index)) && accountType.get(i).equals("customer")) {
				userOwned.add(account.get(i));
			}
		}
		char option = '\0';
		do {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Thank you for using our Banking program " + user.get(index).getName() + "!");
			System.out.println(
					"=======================================================================================================");
			System.out.println("1. Check Balance.");
			System.out.println("2. Deposit.");
			System.out.println("3. Withdraw.");
			System.out.println("4. Transfer.");
			System.out.println("5. Make account joint.");
			System.out.println("6. Exit.");

			System.out.println(
					"=======================================================================================================");
			System.out.println("Please select an option: ");
			option = sc.next().charAt(0);
			System.out.println(
					"=======================================================================================================");
			System.out.println("\n");

			switch (option) {

			case '1':
				if (userOwned.size() == 1) {
					System.out.println("Your current balance is: $" + userOwned.get(0).getBalance());
				} else {
					System.out.println("The balances of your accounts are as follows:");
					for (int i = 0; i < userOwned.size(); i++) {
						System.out.println("Account " + (i + 1) + ": $" + userOwned.get(i).getBalance());
					}
				}

				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
				break;

			case '2':

				if (userOwned.size() == 1) {
					if (userOwned.get(1).isApproved()) {
						Deposit.depo(userOwned.get(1));
						System.out.println("Your new balance is: " + userOwned.get(1).getBalance());
						FileStuff.writeFile(account, new File("AccountFile.txt"));
					} else {
						System.out.println("Account not approved. Please see an admin to approve it.");
					}
				} else {// if user has more than one account
					System.out.println("You have " + userOwned.size()
							+ " accounts. Which account number do you want to deposit to?");
					Scanner in = new Scanner(System.in);
					int input = in.nextInt();
					in.close();
					if (input > userOwned.size() || input < 0) {
						System.out.println("Invalid account number");
					} else {
						if (userOwned.get(input).isApproved()) {
							Deposit.depo(userOwned.get(input));
							System.out.println("Your new balance is: $" + userOwned.get(input).getBalance());
							FileStuff.writeFile(account, new File("AccountFile.txt"));
						} else {
							System.out.println("Account not approved. Please see an admin to approve it.");
						}

					}
				}
				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
				break;

			case '3':

				if (userOwned.size() == 1) {
					if (userOwned.get(1).isApproved()) {
						Withdraw.widr(userOwned.get(1));
						System.out.println("Your new balance is: $" + userOwned.get(1).getBalance());
						FileStuff.writeFile(account, new File("AccountFile.txt"));
					} else {
						System.out.println("Account not approved. Please see an admin to approve it.");
					}
				} else {
					System.out.println("You have " + userOwned.size()
							+ " accounts. Which account number do you want to deposit to?");
					Scanner in = new Scanner(System.in);
					int input = in.nextInt();
					in.close();
					if (input > userOwned.size() || input < 0) {
						System.out.println("Invalid account number");
					} else {
						if (userOwned.get(input).isApproved()) {
							Withdraw.widr(userOwned.get(input));
							System.out.println("Your new balance is: $" + userOwned.get(input).getBalance());
							FileStuff.writeFile(account, new File("AccountFile.txt"));
						} else {
							System.out.println("Account not approved. Please see an admin to approve it.");
						}
					}
				}
				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
				break;

			case '4':

				if (userOwned.size() < 2) {
					System.out.println("You do not own enough accounts to use this functionality.");
				} else {
					System.out.println("You have " + userOwned.size() + " accounts.");
					int first;
					int second;
					Scanner in = new Scanner(System.in);
					System.out.println("Please select the number of the account to transfer from.");
					first = in.nextInt();
					if (first < 0 || first > userOwned.size()) {
						System.out.println("Invalid input.");
					} else if (!userOwned.get(first).isApproved()) {
						System.out.println("Account not approved. Please see an admin to approve it.");
					} else {
						System.out.println("Please select the number of the account to transfer to.");
						second = in.nextInt();

						if (second < 0 || second > userOwned.size()) {
							System.out.println("Invalid input.");
						} else if (!userOwned.get(second).isApproved()) {
							System.out.println("Account not approved. Please see an admin to approve it.");
						} else {
							Transaction.trans(userOwned.get(first), userOwned.get(second));
							FileStuff.writeFile(account, new File("AccountFile.txt"));
						}
						in.close();
					}
				}
				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
				break;
				
			case '5':
				int acc;
				boolean run = false;
				if (userOwned.size() == 1) {
					if (userOwned.get(1).isApproved()) {
						run = true;
						acc = 1;
					}else {
						System.out.println("Account not approved. Please see an admin to approve it.");
					}
				}else {
					System.out.println("You have " + userOwned.size()
					+ " accounts. Which account number do you want to add a user to?");
					Scanner in = new Scanner(System.in);
					acc = in.nextInt();
					if (acc < 0 || acc > userOwned.size()) {
						System.out.println("Invalid input.");
					} else if (!userOwned.get(acc).isApproved()) {
						System.out.println("Account not approved. Please see an admin to approve it.");
					} else {
						run = true;
					}
					in.close();
					Scanner input = new Scanner (System.in);
					String userIn;
					if(run) {//If no errors
						System.out.println("Does the user already have an account? Y/N");
						userIn = input.next();
						if(userIn.equalsIgnoreCase("y")||userIn.equalsIgnoreCase("n")) {
							if(userIn.equalsIgnoreCase("y")) {
								System.out.println("Please log in with existing account.");
								System.out.println("Username:");
								userIn = input.next();
								int userIndex = StartMenu.SearchUsername(user, userIn);
								if (userIndex == -1) {
									System.out.println("Username not found.");
								}else {
									System.out.println("Password:");
									userIn = input.next();
									if(StartMenu.CheckPassword(user, userIn, userIndex)) {
										System.out.println("Successfully logged in. Adding joint account.");
										accountType.add(accountType.get(userIndex));
										user.add(user.get(userIndex));
										account.add(userOwned.get(acc));
										FileStuff.writeFile(accountType, new File ("AccountTypeFile.txt"));
										FileStuff.writeFile(user, new File("UserFile.txt"));
										FileStuff.writeFile(account, new File("AccountFile.txt"));
									}else {
										System.out.println("Password incorrect.");
									}
								}
							}else {
								User newUser = new User();
								System.out.println("Please enter the full name of the new user.");
								newUser.setName(userIn);
								System.out.println("Please enter the username the new user would like to have.");
								newUser.setUsername(input.next());
								Boolean duplicateUsername = false;
								for (int i = 0; i < user.size(); i++) {
									if (newUser.getName().equals(user.get(i).getUsername())) {// If username already exists
										System.out.println("Username already exists. Please use another one.");
										duplicateUsername = true;
									}
								}
								if (duplicateUsername == false) {
									System.out.println("What password would you like? No spaces");
									newUser.setPassword(input.next());
									System.out
											.println("Thank you. New joint account created.");
									accountType.add("customer");
									user.add(newUser);
									account.add(account.get(acc));
									FileStuff.writeFile(accountType, new File ("AccountTypeFile.txt"));
									FileStuff.writeFile(user, new File("UserFile.txt"));
									FileStuff.writeFile(account, new File("AccountFile.txt"));
									
								}
							}
						}else {
							System.out.println("Invalid input.");
						}
					}
					input.close();
				}
				
				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
				break;

			case '6':
				sc.close();

				System.out.println("Thanks for using our services. ");
				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
				break;

			default:
				System.out.println("Please choose an option from 1-5.");
				break;
			}

		} while (option != '6');
		System.out.println(
				"=======================================================================================================");
		System.out.println("Good bye!");
		System.out.println("\n");
		

	}

}
