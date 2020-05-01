package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;

public class FileStuff {
	
	public static void writeFile(ArrayList writeMe, File itWillBeWritten) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream (new FileOutputStream(itWillBeWritten));
			objectOut.writeObject(writeMe);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//read method
	@SuppressWarnings("unchecked")
	public static ArrayList readFile(File readMe, ArrayList fillMe) {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(readMe));
			fillMe = (ArrayList<User>) objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fillMe;
		
		
		
	}
}