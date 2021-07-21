package com.stock;

public class DividendStock extends Stock {
	Double dividend;
	
	public DividendStock(String stockSymbol, int sharesCount, Float stockPrice, Double dividend) {
		super(stockSymbol, sharesCount, stockPrice);
		this.dividend = dividend;
	}

	public Double getDividend() {
		return dividend;
	}

	public void setDividend(Double dividend) {
		this.dividend = dividend;
	}
	
	

}
