package com.stock;
import java.util.ArrayList;
import java.util.HashMap;

public class StockAccount {
	private String name;
	private Float balance;
	private Float totalInvested = 0f;
	private ArrayList<Stock> heldStock = new ArrayList<>();
	
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
	
	public ArrayList<Stock> getHeldStock() {
		return heldStock;
	}

	public void showAccountDetails() {
		System.out.println();
		System.out.println("Your account details:");
		System.out.printf("Name: %s\n", this.name);
		System.out.printf("Account Balance: %.2f\n", this.balance);	
		
		if (this.heldStock.size() > 0) {
			for (Stock s: this.heldStock) {
				System.out.println(s.toString());
			}
			System.out.println("Total Invested: "+this.totalInvested);
			}
		}
	
	public int getStockIndex(String symbol) {
		int index = -1;
		for (int i = 0; i<this.heldStock.size(); i++) {
			if (this.heldStock.get(i).getStockSymbol().equals(symbol)) {
				index = i;
			}
		}
		return index;
	}
	
	
	public void updateStock(HashMap<Object, Object> StockMap, Float totalPrice) throws StockException{
		// if held stock list can be searched
		
		Stock newStock = (Stock) StockMap.get("stock");
		String action = (String) StockMap.get("action");
		int stockIndex = getStockIndex(newStock.getStockSymbol());
		
		
		// stock exists need to append to stock count
		if (action.equals("purchase")) {
			if (stockIndex >= 0) {
				// get old, matching stock
				Stock oldStock = this.heldStock.get(stockIndex);
				// set new stock shares count equivalent to old plus new.
				newStock.setSharesCount(oldStock.getSharesCount() + newStock.getSharesCount());
				// set new total investment
				newStock.setTotalInvested(oldStock.getTotalInvested() + totalPrice);
				// remove old stock entry
				this.heldStock.remove(stockIndex);
				// append new stock entry
				this.heldStock.add(newStock);
				
			// stock does not exist, need to add
			} else {
				// set total investment for initial purchase.
				newStock.setTotalInvested(totalPrice);
				this.heldStock.add(newStock);
			}
		
		// selling stock
		} else {
			// ensure stock exists
			if (stockIndex >= 0) {
				Stock oldStock = this.heldStock.get(stockIndex);
				int shares = oldStock.getSharesCount() - newStock.getSharesCount();
				// if we still have shares append.
				if (shares > 0) {
					oldStock.setSharesCount(shares);
					// Adjust total investment
					oldStock.setTotalInvested(oldStock.getTotalInvested() - totalPrice);
				
				// remove stock, we don't have anymore shares.
				} else {
					this.heldStock.remove(stockIndex);
				}
			} else {
				throw new StockException(" You do not own this stock.");
				}
			}	
		}
			
	
	public void buyStock(HashMap<Object, Object>  stockDetails) throws StockException {
		Stock stock;
		String stockType = (String) stockDetails.get("type");
		if (stockType.equals("dividend")) {
			DividendStock div = (DividendStock) stockDetails.get("stock");
			this.balance = (float) (this.balance + (div.getDividend() * div.getSharesCount()));
			stock = div;
		} else {
			stock = (Stock) stockDetails.get("stock");
		}
		
		Float totalPrice = stock.getStockPrice() * stock.getSharesCount();
		if (totalPrice > this.balance) {
			throw new StockException("Insuffient shares to Complete Transaction.");
		} else {
			HashMap<Object, Object> stockMap = new HashMap<>();
			stockMap.put("action", "purchase");
			stockMap.put("stock", stock);
			try {
				updateStock(stockMap, totalPrice);
				System.out.println(" * Purchase completed, adjusting account balance.\n");
				this.balance = this.balance - totalPrice;
				this.totalInvested = this.totalInvested + totalPrice;
			} catch (StockException e) {
				System.out.println(e.getMessage());
				}
			}
		}
	
	
	public void sellStock(HashMap<Object, Object>  stockDetails) throws StockException {
		Stock stock = (Stock) stockDetails.get("stock");
		Float totalPrice = stock.getStockPrice() * stock.getSharesCount();
		HashMap<Object, Object> stockMap = new HashMap<>();
		stockMap.put("action", "sale");
		stockMap.put("stock", stock);
		
		try {
			updateStock(stockMap, totalPrice);
			this.balance = this.balance + totalPrice;
			this.totalInvested = this.totalInvested - totalPrice;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			}
		}
	
	@Override
	public String toString() {
		return this.heldStock.toString();
		
	}
}

		
		
		
