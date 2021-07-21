package com.simple.account;

import java.util.HashMap;

public class AccountManager {
	private HashMap<Integer, Account> accounts = new HashMap<>();

	public Account getAccount(int id) {
		return (Account) this.accounts.get(id);
	}

	public void addAccount(Account account) {
		int key = account.getAccountID();
		this.accounts.put(key, account);
	}
	
	public void deposit(int id, float amount) {
		this.getAccount(id).deposit(amount);
	}
	
	public void withdraw(int id, float amount) throws InsufficientFundsException {
		this.getAccount(id).withdraw(amount);
	}
	
	@Override
	public String toString() {
			return this.accounts.toString();
	}
	
	
}
