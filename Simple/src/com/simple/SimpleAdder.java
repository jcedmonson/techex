package com.simple;

import java.util.Scanner;

public class SimpleAdder {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		
		int sum = 0;
		for (int x = 10; x<10; x++) {
			System.out.println("Please enter integer #" + (x+1));
			int input = stdin.nextInt();
			if (input < 0) {
				continue;
			}
			
			if (input == 0 ) {
				break;
			}
			sum += input;
		}
		stdin.close();
	}

}
