package com.simple.account;

public class BusinessAccount implements Account {
	private float balance;
	private int accountID;
	private String companyName;
	private String companyAddress;
	
	
	public BusinessAccount(float balance, int accountID, String companyName, String companyAddress) {
		super();
		this.balance = balance;
		this.accountID = accountID;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}
	
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	@Override 
	public String toString() {
		return "A Business Account belonging to " + this.getCompanyName()
			+ " with balance " + this.getBalance();
	}
	
	public void deposit(float amount) {
		this.setBalance(this.getBalance() + amount);
	}
	
	public void withdraw(float amount) throws InsufficientFundsException {
		if (amount > this.getBalance()) {
			throw new InsufficientFundsException(
					"Amount " + amount + " exceeds balance " + this.getBalance());
		}
		this.setBalance(this.getBalance() - amount);
	}
	
}
