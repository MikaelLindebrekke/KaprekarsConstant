package kc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kc.NumberHandlerRevised;

class KaprekarsConstantTest{
	
	private NumberHandlerRevised nh;
	private List<Integer> testNumbers;
	
	
	@BeforeEach
	void setUp() throws Exception {
		nh = new NumberHandlerRevised();
		testNumbers = new ArrayList<Integer>();
		populateTestNumbers();
	}
	
	
	/**
	 * Prints out all the numbers that I test between 1000 and 9999.
	 * 
	 * Total test numbers: 4536
	 */
	@Test
	void printTestNumbers() {
		for (Integer i : testNumbers) {
			System.out.println(i);
		}
		System.out.println("Total test numbers: " + testNumbers.size());
	}
	
	/**
	 * Runs the method on all the numbers
	 */
	@Test
	void testAllNumbers() {
		boolean check = true;
		for (Integer i : testNumbers) {
			System.out.println("Checking " + i);
			
			if (!nh.findConstant(i)) {
				check = false;
			}
		}
		assertTrue(check);
	}
	

	/**
	 * Method used to fill the array with all the numbers to be tested
	 */
	private void populateTestNumbers() {
		for (int i = 1000; i <= 9999; i++) {
			if (numberIsUnique(i)) {
				testNumbers.add(i);
			}
		}
	}
	/**
	 * Method that excludes all numbers that contain duplicates as these numbers don't work.
	 * @param n
	 * @return
	 */
	private boolean numberIsUnique(int n) {
		int arr[] = new int[4];
		int i = 3;
		while (n > 0 && i >= 0) {
			arr[i] = n % 10;
			n = n / 10;
			i--;
		}
		boolean unique = true;
		
		for (int x = 0; x < arr.length; x++) {
			for (int y = x + 1; y < arr.length; y++) {
				if (arr[x] == arr[y]) {
					unique = false;
				}
			}
		}
		return unique;
	}
	
}
