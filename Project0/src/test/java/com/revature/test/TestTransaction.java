package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.revature.beans.Customer;
import com.revature.service.Transaction;

class TestTransaction {
	
	Customer a = new Customer("ABCD12345", "Mikey", 200);
	Customer b = new Customer("CBDA65123", "Steven", 150);
	
	Transaction transaction = new Transaction();

	@Test
	void transactionTest() {
		  transaction.trans(a, b);
		  //expected, actual
          assertEquals(150, a.getBalance());
          assertEquals(200, b.getBalance());

	}


}
