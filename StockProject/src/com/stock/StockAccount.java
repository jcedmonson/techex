package com.stock;


public class StockAccount {
	private String name;
	private Float balance;
	
public StockAccount(String name, Float balance) {
	super();
	this.name = name;
	
	
	if (balance < 0) {
		System.out.println("Balance can not be negative, resetting account");
;		this.balance = 1000f;
	} else {
		this.balance = balance;
	};
	
	
}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	public void showAccountDetails() {
		System.out.println();
		System.out.printf("Your account details:");
		System.out.printf("Name: %s\n", this.name);
		System.out.printf("Account Balance: %.2f\n", this.balance);
	}
	
	
}
