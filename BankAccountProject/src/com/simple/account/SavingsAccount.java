package com.simple.account;

public class SavingsAccount extends BankAccount implements Account {
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

	@Override
	public void print() {
		System.out.println("\nSavings Summary:");
		System.out.println("   Interest rate:" + this.getInterestRate());
		System.out.println("Minimum Balance:" + minimumBalance);
	}
	
	@Override
	public String toString() {
		return super.toString() +
				" with interest rate " + this.getInterestRate() +
				" and minimum balance " + this.minimumBalance;
	}
	
	
	
	
}
