package com.stock;


public class StockAccount {
	private String name;
	private Float balance;
	
	
	
	
	
	Stock heldStock = null;
	
public StockAccount(String name, Float balance) {
	System.out.printf("Creating new account, balance is %.2f.\n", balance);
	this.name = name;
	this.balance = balance;
}

public StockAccount(String name) {
	this(name, 1000f);

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
		System.out.println("Your account details:");
		System.out.printf("Name: %s\n", this.name);
		System.out.printf("Account Balance: %.2f\n", this.balance);
		
		if (this.heldStock != null) {
			System.out.printf("You own %d shares of %s\n", 
					this.heldStock.getSharesCount(), this.heldStock.getStockSymbol());
		}
	}
	
	public void getStock(String symbol, int shares, Float price) {
		this.heldStock = new Stock(symbol, shares, price);
	}
	
	public void buyStock(Stock stock) {
		Float totalPrice = stock.getStockPrice() * stock.getSharesCount();
		if (totalPrice > this.balance) {
			System.out.println("Insufficient funds for stock purchase.");
		} else {
			System.out.println("Purchase Allowed.");
			this.heldStock = stock;
			this.balance = this.balance - totalPrice;
		}
	}
	
	public boolean validSale(Stock stock) {
		// if stocks match.
		if (stock.getStockSymbol().equals(this.heldStock.getStockSymbol())) {
			System.out.println("User owns stock.");
			// if count of share are less than or equal to owned.
			if (stock.getSharesCount() <= this.heldStock.getSharesCount()) {
				System.out.println("User owns enough stock.");
				return true;
			} 
		}
		return false;
	}
	
	public void saleDetails(Stock stock) {
		System.out.printf("Sale of %f %s stocks complete.\n", stock.getSharesCount(), stock.getStockSymbol());
		System.out.println("Updating Account:");
		// print new account balance.
		
	}
	
	
	
	public void sellStock(Stock stock) {
		Float totalPrice = stock.getStockPrice() * stock.getSharesCount();
		if(this.heldStock.equals(null)) {
				// user does not own any stock
				System.out.println("You dont have any stock to sell.");
			} else if (validSale(stock)) {
				// can sell
				// adjust shares
				this.heldStock.setSharesCount(
						this.heldStock.getSharesCount()-stock.getSharesCount());
				// adjust account balance, adding from sale...
				this.setBalance(this.balance+totalPrice);
				// check shares exist, if not, set local stock var to null.
				if (this.heldStock.getSharesCount() == 0) {
					this.heldStock = null;
				}
				
			} else {
				// requirements are not met
				System.out.println("Insuffient shares to Complete Transaction.");
			}
		}
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
}	

