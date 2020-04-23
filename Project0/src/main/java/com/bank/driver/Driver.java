package com.bank.driver;

import java.util.Scanner;

public class Driver {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userIn = new Scanner(System.in);
		String input;
		boolean doneRight = false;
		
		System.out.println("Welcome to the bank!");
		while (!doneRight) { //While the user hasn't given a correct input, ask them for a good input
			System.out.println("Do you have an account? Y/N");		
			input = userIn.next();
			if(!input.toLowerCase().equals("y") && !input.toLowerCase().equals("n")){ //if not y or n
				System.out.println("Invalid input. Try again."); //error message
			}else { //if correct input
				doneRight = true; //leave loop
			}
		}

		System.out.println("Please enter your username:");
		input = userIn.next();
	}

}
