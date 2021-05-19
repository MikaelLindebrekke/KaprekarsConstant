package kc;
/**
 * Class that handles all the manipulations of the number you choose. 
 * 
 * @author Mikael
 *
 */
public class NumberHandler {

	private int[] numArray;
	private int number;
	private int numHigh;
	private int numLow;
	private boolean finished = false;
	
	
	public NumberHandler() {
		
	}
	
	public void setUp(int number) {
		this.numArray = new int[4];
		this.number = number;
		populateArray();
		rearrangeHigh();
	}
	
	public void run() {
		while (!(number == 6174)) {
			
			System.out.println("Rearranging...");
			rearrangeHigh();
			System.out.println("...from high to low: " + numHigh);
			
			rearrangeLow();
			System.out.println("...from low to high: " + numLow);
			
			subtract();
			
			populateArray();
		}
		finished = true;
		System.out.println("Your choosen number has reached Kaprekar's Constant!");
	}
	
	/**
	 * Rearranges the number from high to low
	 */
	private void rearrangeHigh() {
		for (int i = 0; i < numArray.length; i++) {
			for (int j = i + 1; j <numArray.length; j++) {
				int temp = 0;
				if (numArray[i] < numArray[j]) {
					temp = numArray[i];
					numArray[i] = numArray[j];
					numArray[j] = temp;
				}
			}
		}
		String numAsString = "";
		
		for (int n : numArray) {
			String s = Integer.toString(n);
			numAsString = numAsString + s;
		}
		
		numHigh = Integer.parseInt(numAsString);
		
		
	}
	
	/**
	 * Rearranges the number from low to high
	 */
	private void rearrangeLow() {
		for (int i = 0; i < numArray.length; i++) {
			for (int j = i + 1; j <numArray.length; j++) {
				int temp = 0;
				if (numArray[i] > numArray[j]) {
					temp = numArray[i];
					numArray[i] = numArray[j];
					numArray[j] = temp;
				}
			}
		}
		String numAsString = "";
		
		for (int n : numArray) {
			String s = Integer.toString(n);
			numAsString = numAsString + s;
		}
		
		numLow = Integer.parseInt(numAsString);
		
	}
	
	/**
	 * Substracts low from high. 
	 */
	private void subtract() {
		System.out.println("Subtracting " + numLow + " from " + numHigh);
		number = numHigh - numLow;
		System.out.println("New number is " + number + "\n---------------------");
		
	}
	
	private void populateArray() {
		int n = number;
		int i = 3;
		while (n > 0 && i >= 0) {
			numArray[i] = n % 10;
			n = n / 10;
			i--;
		}
	}
	
	public boolean isUniqueDigits() {
		boolean check = false; 
		for (int i = 1 ; i < numArray.length; i++) {
			if (numArray[i - 1] == numArray[i]) {
				check = true;
			}
		}
		System.out.println("---------------------\nChoosen number: " + number);
		return check;
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
}
