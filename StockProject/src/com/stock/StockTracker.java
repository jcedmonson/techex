package com.stock;

import java.util.HashMap;
import java.util.Scanner;

public class StockTracker {

	public static void main(String[] args) {
		System.out.println("This program will help you track information about your investments.");
		Scanner stdin = new Scanner(System.in);
		
		// create account
		StockAccount sa = createAccount(stdin);
	
		// show details
		sa.showAccountDetails();
	
		while (true) {
			
			try {
				System.out.println("\nMake a selection.");
				System.out.println("1. Buy Stock");
				System.out.println("2. Sell Stock");
				System.out.println("3. Quit Application");
				int selection = stdin.nextInt();
				switch (selection) {
				case 1:
					buyStock(stdin, sa);
					sa.showAccountDetails();
					break;
	
				case 2:
					sellStock(stdin, sa);
					sa.showAccountDetails();
					break;
				case 3:
					System.out.println(" * Exiting Application.");
					stdin.close();
					System.exit(0);
					break;
					}
				} catch (Exception e) {
					System.out.println(" * Invalid Selection");
				}
			}
			
		}
		
		
	public static StockAccount createAccount(Scanner stdin) {
		// create account
		// get name
		System.out.println("Enter your Name:");
		String name = stdin.nextLine();
		
		// get account balance
		System.out.println("Enter your account balance:");
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
		return sa;	
	}
	
		
		
		
	public static void buyStock(Scanner stdin, StockAccount sa) {
		System.out.println("Its time for you to buy some s t o c k.");
		// get stock of interest
		HashMap<Object, Object> stockDetails = getStockInfo(stdin);
		Stock stock = (Stock) stockDetails.get("stock");
		
		// purchase specified stock
			// if user enters 0, doesn't want to purchase anything.
		if (stock.getSharesCount() > 0) {
			try {
				System.out.printf(" * Attempting to purchase %d shares of %s for $%.2f.\n", 
						stock.getSharesCount(), stock.getStockSymbol(), 
						(stock.getStockPrice()*stock.getSharesCount()));
				sa.buyStock(stockDetails);
			} catch (StockException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void sellStock(Scanner stdin, StockAccount sa) {
		if (sa.getHeldStock().size() > 0){
			System.out.println("Its time for you to sell some s t o c k.");
			
			// get stock of interest
			HashMap<Object, Object> stockDetails = getStockInfo(stdin);
			Stock sellStock = (Stock) stockDetails.get("stock");
			
			try {
				System.out.printf(" * Attempting to sell %d shares of %s for $%.2f.\n", 
						sellStock.getSharesCount(), sellStock.getStockSymbol(), 
						(sellStock.getStockPrice()*sellStock.getSharesCount()));
				sa.sellStock(stockDetails);
			} catch (StockException e) {
				System.out.println(e.getMessage());;
			}
		} else {
			System.out.println("You dont have any stock to sell...");
		}
	}
	
	
	
	
	public static HashMap<Object, Object> getStockInfo(Scanner stdin) {
		// symbol
		System.out.println("Please enter the Symbol Info.");
		stdin.nextLine();
		String symbol = stdin.nextLine();
		// shares count
		System.out.println("Please enter the number of shares.");
		int sharesCount = stdin.nextInt();
		stdin.nextLine();
		// price
		System.out.println("Please enter the price.");
		Float sharePrice = stdin.nextFloat();
		stdin.nextLine();
		
		System.out.println("Is the stock a dividend stock? y/n");
		String resp = stdin.nextLine().toLowerCase();
		
		System.out.println("Enter the dividend value:");
		Double dividend = stdin.nextDouble();
		stdin.nextLine();
		
		HashMap<Object, Object> stockDetails = new HashMap<>();
		switch (resp) {
		case "y":
			stockDetails.put("type", "dividend");
			stockDetails.put("stock", new DividendStock(symbol, sharesCount, sharePrice, dividend));
			break;

		case "n":
			stockDetails.put("type", "standard");
			stockDetails.put("stock", new Stock(symbol, sharesCount, sharePrice));
			break;
		}
		return stockDetails;
	}
}
