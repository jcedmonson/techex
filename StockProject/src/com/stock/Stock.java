package com.stock;

public class Stock {
	private String stockSymbol;
	private int sharesCount;
	private Float stockPrice;
	
	public Stock(String stockSymbol, int sharesCount, Float stockPrice) {
		super();
		this.stockSymbol = stockSymbol;
		this.sharesCount = sharesCount;
		this.stockPrice = stockPrice;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public int getSharesCount() {
		return sharesCount;
	}
	public void setSharesCount(int sharesCount) {
		this.sharesCount = sharesCount;
	}
	public Float getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(Float stockPrice) {
		this.stockPrice = stockPrice;
	}
}
