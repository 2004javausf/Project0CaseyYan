package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;

public class Roster {
	
	public static List<Customer> customerList = new ArrayList<Customer>();
	
	@SuppressWarnings("unlikely-arg-type")
	public static Customer findCustomerById(String inputId) {
		for(int i=0; i<customerList.size(); i++) {
			String id = customerList.get(i).getId();
			if(inputId.equals(id)){
				return customerList.get(i);
			}
		}
				System.out.println("Customer Not Found");
				return null;
	}

}
