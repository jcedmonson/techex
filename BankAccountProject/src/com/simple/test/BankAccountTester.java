package com.simple.test;

import com.simple.account.BankAccount;
import com.simple.account.InsufficientFundsException;
import com.simple.account.SavingsAccount;

public class BankAccountTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount accountOne = new BankAccount(1, "Jeff Lebowski" , 100f);
		BankAccount accountTwo = new BankAccount(2, "Bunny Lebowski", 5000f);
		BankAccount accountThree = new BankAccount(3, "Walter Sobcheck", 1000000f);
		SavingsAccount sAccount = new SavingsAccount(1, "Donny K", 1f);
		
		System.out.println(accountOne);
		System.out.println(accountTwo);
		System.out.println(accountThree);
		System.out.println(sAccount);
		
		try {
			accountOne.withdraw(200f);
		} catch (InsufficientFundsException e) {
			System.out.println("There was an error withdrawing funds");
			System.out.println(e.getMessage());
		}

		
	}

}

