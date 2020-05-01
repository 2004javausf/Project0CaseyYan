package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.beans.Account;
import com.revature.service.Withdraw;

class TestWithdraw {

	Account a = new Account(200, true);
	Account b = new Account(150, true);
	Withdraw withdraw = new Withdraw();

	@Test
	void withdrawTestA() {//withdraw 50
		  withdraw.widr(a);
		  //expected, actual
          assertEquals(150, a.getBalance());
	}
}
