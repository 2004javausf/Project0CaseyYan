package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.beans.Account;
import com.revature.service.Deposit;

class TestDeposit {
	
	Account a = new Account(200, true);
	Deposit deposit = new Deposit();

	@Test
	void depositTest() {//Manually transfer 50
		  deposit.depo(a);
		  //expected, actual
          assertEquals(250, a.getBalance());
	}

}
