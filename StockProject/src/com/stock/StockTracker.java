package com.stock;

import java.util.Scanner;

public class StockTracker {

	public static void main(String[] args) {
		System.out.println("This program will help you track information about your investments.");
		
		Scanner stdin = new Scanner(System.in);
		
		// create account
		// get name
		System.out.println("Enter your Name");
		String name = stdin.nextLine();
		
		// get account balance
		System.out.println("Enter your account balance");
		Float balance = stdin.nextFloat();
		
		
		StockAccount sa;
		if (balance < 0) {
			System.out.println("Negative balances are not allowed.");
			// instantiate new stock account
			sa = new StockAccount(name);
		} else {
			// instantiate new stock account
			sa = new StockAccount(name, balance);
		}
		
		
		// show details
		sa.showAccountDetails();
		
		System.out.println("Its time for you to buy some s t o c k.");
		
		
		// get stock of interest
		Stock stock = getStockInfo();
		
		// purchase specified stock
		sa.buyStock(stock);
		
		sa.showAccountDetails();
		
		
		System.out.println("You will now be selling stock.");
		
		Stock sellStock = getStockInfo();
		sa.sellStock(sellStock);
		
		sa.showAccountDetails();
		stdin.close();
		
	}
	
	public static Stock getStockInfo() {
		Scanner stdin = new Scanner(System.in);
		// symbol
		System.out.println("Please enter the Symbol Info.");
		String symbol = stdin.nextLine();
		// shares count
		System.out.println("Please enter the number of shares.");
		int sharesCount = stdin.nextInt();
		stdin.nextLine();
		// price
		System.out.println("Please enter the price.");
		Float sharePrice = stdin.nextFloat();
		stdin.close();
		return new Stock(symbol, sharesCount, sharePrice);
	}
}
