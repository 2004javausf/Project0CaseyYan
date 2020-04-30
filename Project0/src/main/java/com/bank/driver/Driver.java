package com.bank.driver;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Driver {

	public static void main(String[] args) {

		ArrayList<String> accountType = new ArrayList<String>(); // create 3 column table of infinite length (arrayList)
		ArrayList<User> userObject = new ArrayList<User>();
		ArrayList<Account> accountObject = new ArrayList<Account>();

		File accountTypeFile = new File("AccountTypeFile.txt");
		File userFile = new File("UserFile.txt");
		File accountFile = new File("AccountFile.txt");

		Scanner accountTypeReader;
		try {
			accountTypeReader = new Scanner(accountTypeFile);
			while (accountTypeReader.hasNext()) { // Read in account types to table
				accountType.add(accountTypeReader.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileInputStream userReader;
		try {
			userReader = new FileInputStream(userFile);
			ObjectInputStream userObjects = new ObjectInputStream(userReader);
			while (userObjects.available() != 0) { // Read in user account objects to table
				userObject.add((User) userObjects.readObject());

			}
			userReader.close();
			userObjects.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		FileInputStream accountReader;
		try {
			accountReader = new FileInputStream(accountFile);
			ObjectInputStream accountObjects = new ObjectInputStream(accountReader);
			while (accountObjects.available() != 0) {
				accountObject.add((Account) accountObjects.readObject());
			}
			accountReader.close();
			accountObjects.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// closing readers

		Scanner userIn = new Scanner(System.in);
		String input = null;
		boolean doneRight = false;

		System.out.println("Welcome to the bank!");
		while (!doneRight) { // While the user hasn't given a correct input, ask them for a good input
			System.out.println("Do you have an account? Y/N");
			input = userIn.next();
			if (!input.toLowerCase().equals("y") && !input.toLowerCase().equals("n")) { // if not y or n
				System.out.println("Invalid input. Try again."); // error message
			} else { // if correct input
				doneRight = true; // leave loop
			}
		}
		if (input.toLowerCase().equals("y")) {// If user has an account, ask for credentials
			int userIndex = -1;

			System.out.println("Please enter your username:");
			input = userIn.next();
			userIndex = SearchUsername(userObject, input); // parse username
			if (userIndex == -1) { // If username not found
				// TODO add multiple attempts
				System.out.println("Error. Account not found."); // Error message, no further behavior
			} else {
				System.out.println("Please enter your password:");
				input = userIn.next();
				if (CheckPassword(userObject, input, userIndex)) {// check if correct password
					// Authenticated. Find what types of accounts this user has access to
					boolean customer = false;
					boolean employee = false;
					boolean admin = false;
					User authenticated = userObject.get(userIndex);
					for (int i = 0; i < userObject.size(); i++) {
						if (userObject.get(i).equals(authenticated)) {// If this is an account owned by our
																		// authenticated user
							if (accountType.get(i).equals("customer")) { // If this is customer, enable customer
								customer = true;
							} else if (accountType.get(i).equals("employee")) {// If this is an employee, enable
																				// employee
								employee = true;
							} else if (accountType.get(i).equals("admin")) {// If this is an admin, enable admin
								admin = true;
							}
						}
					}
					if ((customer ^ employee ^ admin) ^ (customer && employee && admin)) {// If only one account type,
																							// skip account selection

					} else { // If multiple account types
						doneRight = false;
						while (!doneRight) {
							System.out.println("Please select what account type you would like to access:");
							if (customer == true) {
								System.out.println("1: Customer Account");
							}
							if (employee == true) {
								System.out.println("2: Employee Account");
							}
							if (admin == true) {
								System.out.println("3: Admin Account");
							}
							input = userIn.next();
							//check for valid input
							if (input.equals("1") && customer) {
								doneRight = true;
								employee = false;
								admin = false;
							}else if (input.equals("2") && employee) {
								doneRight = true;
								customer = false;
								admin = false;
							}else if (input.equals("3") && admin) {
								doneRight = true;
								customer = false;
								employee = false;
							}else {
								System.out.println("Invalid input.");
							}
						}
					}
					//TODO add UI implementation
					if(customer) {
						//Run customer UI
					}else if (employee) {
						//Run employee UI
					}else if (admin) {
						//Run admin UI
					}
					
				} else {
					// TODO add multiple attempts
					System.out.println("Invalid password. Try again");
				}

			}

		} else {
			System.out.println("Please make an account");
			//TODO make account creation
		}
	}

	private static boolean CheckPassword(ArrayList<User> userObject, String input, int userIndex) { // check index
																									// returned under
																									// username for
																									// correct password
		if (input.equals(userObject.get(userIndex).getPassword())) {// if coupled password matches username, return true
			return true;
		}

		return false;
	}

	private static int SearchUsername(ArrayList<User> userObject, String input) { // check for username and return if it
																					// exists
		for (int i = 0; i < userObject.size(); i++) {

			if (input.equalsIgnoreCase((userObject.get(i)).getUsername())) {
				return i;
			} else {
				i++;
			}
		}

		return -1;

	}
}