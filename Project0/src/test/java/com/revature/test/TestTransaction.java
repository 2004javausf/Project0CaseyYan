package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.beans.Account;
import com.revature.service.Transaction;

class TestTransaction {
	
	Account a = new Account(200, true);
	Account b = new Account(150, true);
	
	Transaction transaction = new Transaction();

	@Test
	void transactionTest() {
		  transaction.trans(a, b); //Manually transfer 50$
		  //expected, actual
          assertEquals(150, a.getBalance());
          assertEquals(200, b.getBalance());

	}


}

