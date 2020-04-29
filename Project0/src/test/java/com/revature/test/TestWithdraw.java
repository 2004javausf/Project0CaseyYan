package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.beans.Customer;
import com.revature.service.Withdraw;

class TestWithdraw {

	Customer a = new Customer("ABCD12345", "Mikey", 200, 50);
	Customer b = new Customer("CBDA65123", "Steven", 150, 100);
	Withdraw withdraw = new Withdraw();

	@Test
	void withdrawTestA() {
		  withdraw.widr(a);
		  //expected, actual
          assertEquals(150, a.getBalance());
	}
	
	@Test
	void withdrawTestB() {
		  withdraw.widr(b);
		  //expected, actual
          assertEquals(50, b.getBalance());
	}
}
