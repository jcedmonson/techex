package com.simple.test;

import com.simple.account.AccountManager;
import com.simple.account.BankAccount;
import com.simple.account.BusinessAccount;
import com.simple.account.SavingsAccount;

public class AccountManagerTester {

	public static void main(String[] args) {
		AccountManager manager = new AccountManager();
		BankAccount account = new BankAccount(1, "Jeff Lebowski", 90f);
		SavingsAccount sAccount = new SavingsAccount(2, "Maude Lebowski", 10000f);
		BusinessAccount busAccount = new BusinessAccount(100f, 3, "SimpleCorp", "123 Fake Street");
		
		manager.addAccount(account);
		manager.addAccount(sAccount);
		manager.addAccount(busAccount);
		
		manager.deposit(2, 100f);
		System.out.println(manager.getAccount(2));
		
	}

}
