package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.menu.Menu;

public class Roster {
	
	public static List<User> customerList = new ArrayList<User>();
	
	public static User findCustomerById(String inputId) {
		for(int i=0; i<customerList.size(); i++) {
			String id = customerList.get(i).getId();
			if(inputId.equals(id)){
				return customerList.get(i);
			}
		}
				System.out.println("Customer Not Found");
				Menu.startMenu();
				return null;
	}

}
