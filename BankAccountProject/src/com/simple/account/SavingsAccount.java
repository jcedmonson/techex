package com.simple.account;

public class SavingsAccount extends BankAccount {
	private float minimumBalance = 1000;

	public SavingsAccount(int accountID, String ownerName, float balance) {
		super(accountID, ownerName, balance);
	}
	
	public void payInterest() {
		float newBalance = this.getBalance() * (1
				+ (this.getInterestRate() / 100));
		if (this.getBalance() >= this.minimumBalance) {
			this.setBalance(newBalance);
		}
		
	}
	
	
}
