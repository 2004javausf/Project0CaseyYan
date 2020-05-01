package com.revature.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.service.Deposit;
import com.revature.service.Transaction;
import com.revature.service.Withdraw;

public class CustomerMenu {

	public static void serviceMenu(ArrayList<String> accountType, ArrayList<User> user, ArrayList<Account> account,
			int index) {

		Deposit depo = new Deposit();
		Transaction trans = new Transaction();
		Withdraw widr = new Withdraw();

		Scanner scan = new Scanner(System.in);

		ArrayList<Account> userOwned = new ArrayList<Account>();
		for (int i = 0; i < user.size(); i++) {// create an array of all owned accounts
			if (user.get(i).equals(user.get(index)) && accountType.get(i).equals("customer")) {
				userOwned.add(account.get(i));
			}
		}
		do {
			char option = '\0';
			Scanner sc = new Scanner(System.in);
			System.out.println("Thank you for using our Banking program " + user.get(index).getName() + "!");
			System.out.println(
					"=======================================================================================================");
			System.out.println("1. Check Balance.");
			System.out.println("2. Deposit.");
			System.out.println("3. Withdraw.");
			System.out.println("4. Transfer.");
			System.out.println("5. Exit.");

			System.out.println(
					"=======================================================================================================");
			System.out.println("Please select an option: ");
			option = sc.next().charAt(0);
			System.out.println(
					"=======================================================================================================");
			System.out.println("\n");

			switch (option) {

			case '1':
				if(userOwned.size() == 1) {
					System.out.println("Your current balance is: $" + userOwned.get(0).getBalance());
				}else {
					System.out.println("The balances of your accounts are as follows:");
					for (int i = 0; i<userOwned.size(); i++) {
						System.out.println("Account " + (i+1) + ": $" + userOwned.get(i).getBalance());
					}
				}

				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
				break;

			case '2':
				
				if(userOwned.size() == 1) {
					Deposit.depo(userOwned.get(1));
				}
				else {//check account size
					System.out.println("You have " + userOwned.size() + " accounts. Which account number do you want to deposit to?");
					Scanner in = new Scanner(System.in);
					int input = in.nextInt();
					in.close();
					if(input > userOwned.size() || input < 0) {
						System.out.println("Invalid account number");
					}else {
						
					}
				}
				Deposit.depo(a);
				Deposit d = new Deposit();
				int amount1 = d.getAmount1();
				System.out.println("Your deposit amounts are: " + Math.abs(amount1));
				System.out.println("Your current balances are: " + a.getBalance());
				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
				break;

			case '3':

				Withdraw.widr(a);
				Withdraw w = new Withdraw();
				int amount2 = w.getAmount2();
				System.out.println("Your withdraw amounts are: " + Math.abs(amount2));
				System.out.println("Your current balances are: " + a.getBalance());
				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
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
				System.out.println(a.getName() + " just transfered " + amount3 + " to Customer " + b.getName());
				System.out.println(a.getName() + " 's balance is now " + a.getBalance());
				System.out.println(b.getName() + " 's HP is now " + b.getBalance());
				System.out.println(
						"=======================================================================================================");
				serviceMenu();
				break;

			case '5':

				System.out.println("Thanks for using our services. ");
				System.out.println("\n");
				System.out.println(
						"=======================================================================================================");
				serviceMenu();
				break;

			default:
				System.out.println("Please make a option from 1-4.");
				serviceMenu();
				break;
			}

		} while (option != '5');
		System.out.println(
				"=======================================================================================================");
		System.out.println("Good bye!");
		System.out.println("\n");

	}

}
