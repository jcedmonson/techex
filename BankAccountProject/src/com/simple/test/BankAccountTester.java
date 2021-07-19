package com.simple.test;

import com.simple.account.BankAccount;
import com.simple.account.SavingsAccount;

public class BankAccountTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount accountOne = new BankAccount(1, "Jeff Lebowski" , 100f);
		accountOne.setInterestRate(5.5f);
	
		SavingsAccount sAccount = new SavingsAccount(1, "Jeff Lebowski", 1f);
		sAccount.deposit(500f);
		sAccount.payInterest();
		System.out.println("The Savings Accounts new balance is " +
				sAccount.getBalance());

	}

}

