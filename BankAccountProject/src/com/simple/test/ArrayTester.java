package com.simple.test;

import com.simple.account.BankAccount;
import com.simple.account.SavingsAccount;

public class ArrayTester {

	public static void main(String[] args) {
		BankAccount[] accounts = new BankAccount[4];
		accounts[2] = new BankAccount(3, "Bunny Lebowski", 1f);
		accounts[0] = new SavingsAccount(1, "Jeff Lebowsik", 100f);
		
		BankAccount first = accounts[0];
		System.out.println("First account has id:" + first.getAccountID());
	}
}
