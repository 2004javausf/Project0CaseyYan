package com.revature.driver;

import java.io.File;
import java.util.ArrayList;

import com.bank.driver.StartMenu;
import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.FileStuff;

public class Driver {
	
	public static void main(String[] args) {
		
		ArrayList<String> accountType = new ArrayList<String>(); // create 3 column table of infinite length (arrayList)
		ArrayList<User> userObject = new ArrayList<User>();
		ArrayList<Account> accountObject = new ArrayList<Account>();
		
		File accountTypeFile = new File("AccountTypeFile.txt");
		File userFile = new File("UserFile.txt");
		File accountFile = new File("AccountFile.txt");
		
		accountType = FileStuff.readFile(accountTypeFile, accountType);
		userObject = FileStuff.readFile(userFile, userObject);
		accountObject = FileStuff.readFile(accountFile, accountObject);
		
		User auron = new User("Auron", "REVATURE1234", "Dead");
		User tidus = new User("Tidus", "REVATURE0001", "BetterThanDad");
		userObject.add(auron);
		userObject.add(tidus);
		accountType.add("admin");
		accountType.add("employee");
		accountObject.add(null);
		accountObject.add(null);
		
		StartMenu.Menu(accountType, userObject, accountObject, accountTypeFile, userFile, accountFile);;
		
		
	}

}
