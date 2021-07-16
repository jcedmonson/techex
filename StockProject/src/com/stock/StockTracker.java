package com.stock;

import java.util.Scanner;

public class StockTracker {

	public static void main(String[] args) {
		System.out.println("This program will help you track information ");
		System.out.println("about your investments.");
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("Enter your Name");
		String name = stdin.nextLine();
		System.out.println("Enter your account balance");
		Float balance = stdin.nextFloat();
		
		StockAccount sa = new StockAccount(name, balance);
		sa.showAccountDetails();
		
	}
}
