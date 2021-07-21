package com.simple.account;

public interface Account {
	public void withdraw(float amount) throws InsufficientFundsException;
	public void deposit(float amount);
	public int getAccountID();
}
