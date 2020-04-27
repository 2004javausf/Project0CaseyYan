package com.bank.driver;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		String input = null;
		boolean doneRight = false;
		File username = new File("Username.txt");
		File password = new File("Password.txt");

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
		if (input.toLowerCase().equals("y")) {//If user has an account, ask for credentials
			int userIndex=-1;
			
			System.out.println("Please enter your username:");
			input = userIn.next();
			userIndex = SearchUsername(username, input); //parse username
			if (userIndex == -1) { //If username not found
				// TODO add finite attempts
				System.out.println("Error. Account not found."); //Error message, no further behavior
			}else {
			System.out.println("Please enter your password:");
			input = userIn.next();
			System.out.println(CheckPassword(password, input, userIndex)); //check if correct password
			}
			
		} else {
			System.out.println("Please make an account");
		}
	}

	private static boolean CheckPassword(File password, String input, int userIndex) { //check index returned under username for correct password
		try {
			Scanner fileScan = new Scanner(password);
				for(int i=0; i<userIndex; i++) {
					fileScan.next();
				}
				if(input.equals(fileScan.next())) {
					return true;
				}
			}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	private static int SearchUsername(File username, String input) { //check for username and return if it exists
		try {
			int i=0; //find the index that this account is listed under
			Scanner fileScan = new Scanner(username);
			while (fileScan.hasNext()) {
				if (fileScan.next().toLowerCase().equals(input.toLowerCase())) {
					return i;
				}else {
					i++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return -1;

	}

	private static void ErrorHandle(String s) {
		try {

		} catch (Exception e) {

		}
	}
}