package com.revature.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;

public class FileStuff {
	public static final String customerFile= "customerList.txt";
	//write method
//	public static void writeWarriorFile(String fileName, ArrayList<?> a, Class c) {
	public static void writeCustomerFile(List<Customer> a) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream (new FileOutputStream(customerFile));
			objectOut.writeObject(a);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}