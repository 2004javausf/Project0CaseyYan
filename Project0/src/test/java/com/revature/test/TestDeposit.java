package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.beans.Customer;
import com.revature.service.Deposit;

class TestDeposit {
	
	Customer a = new Customer("ABCD12345", "Mikey", 200);
	Deposit deposit = new Deposit();

	@Test
	void depositTest() {
		  deposit.depo(a);
		  //expected, actual
          assertEquals(250, a.getBalance());
	}

}
