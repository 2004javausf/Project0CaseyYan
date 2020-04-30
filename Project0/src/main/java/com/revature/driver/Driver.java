package com.revature.driver;

import com.revature.beans.Customer;
import com.revature.menu.Menu;
import com.revature.util.FileStuff;
import com.revature.util.Roster;

public class Driver {
	
	public static void main(String[] args) {
		
		Customer auron = new Customer("Auron", "REVATURE1234", 200);
		Customer tidus = new Customer("Tidus", "REVATURE0001", 500);
		FileStuff.customerList.add(auron);
		FileStuff.customerList.add(tidus);
		FileStuff.writeCustomerFile();
		System.out.println(Roster.customerList.toString());
		FileStuff.readCustomerFile();
		System.out.println(Roster.customerList.toString());
		System.out.println("============================");
		Menu.startMenu();
		
		
	}

}
