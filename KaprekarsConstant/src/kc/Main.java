package kc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * Just a simple program that i made for fun that proves that Kaprekar's Constant works.
 * 
 * @author Mikael
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("** Welcome to Kaprekar's Constant! **");
		System.out.println("This little program is made to prove that the theory actually works.");
		System.out.println("-------------------------------------------------------------------");
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		int number = 0;
		NumberHandler nh = new NumberHandler();
		
		while (!nh.isFinished()) {
			System.out.println("Enter 4 unique digits: ");
			try {
				number = scanner.nextInt();
				nh.setUp(number);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
		
			
			if (nh.isUniqueDigits()) {
				System.out.println("Please enter only unique digits!");
			} else {
				nh.run();
			}
			
			
		}
		scanner.close();
		
	}
	


}
