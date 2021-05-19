package kc;
/**
 * Class that handles all the manipulations of the number you choose. 
 * 
 * Changed the original class so that is it simpler for the test on all numbers. 
 * 
 * @author Mikael
 *
 */
public class NumberHandlerRevised {

	public NumberHandlerRevised() {}
	
	public boolean findConstant(int number) {
		
		boolean constantFound = false;
		
		while(!constantFound) {
			
			int numHigh = rearrangeHigh(number);
			int numLow = rearrangeLow(number);

			number = numHigh - numLow;

			if (number == 6174) {
				constantFound = true;
			}
		}
		return constantFound;
	}
	
	/**
	 * Rearranges the number from high to low
	 */
	private int rearrangeHigh(int n) {
		int arr[] = new int[4];
		int x = 3;
		while (n > 0 && x >= 0) {
			arr[x] = n % 10;
			n = n / 10;
			x--;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j <arr.length; j++) {
				int temp = 0;
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		String numAsString = "";
		
		for (int y : arr) {
			String s = Integer.toString(y);
			numAsString = numAsString + s;
		}
		
		return Integer.parseInt(numAsString);
		
		
	}
	
	/**
	 * Rearranges the number from low to high
	 */
	private int rearrangeLow(int n) {
		int arr[] = new int[4];
		int x = 3;
		while (n > 0 && x >= 0) {
			arr[x] = n % 10;
			n = n / 10;
			x--;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int temp = 0;
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		String numAsString = "";
		
		for (int y : arr) {
			String s = Integer.toString(y);
			numAsString = numAsString + s;
		}
		
		return Integer.parseInt(numAsString);
		
	}
	
}
