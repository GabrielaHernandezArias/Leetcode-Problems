/*
 *  this is really fun
 *  
 *  read: https://www.geeksforgeeks.org/different-ways-to-print-fibonacci-series-in-java/
 *  efficiency: https://stackoverflow.com/questions/21710756/recursion-vs-iteration-fibonacci-sequenc
 *  
 *  FIBONACCI SERIES:
 *  0 1 1 2 3 5 8 13 21 34
 *  
 *  ^ the next number is the sum of the last two previous numbers
 *  
 *  this code will show two approaches: iterative and recursive, with time and space complexity comparisons 
 *  
 */
public class Fibonacci {

	/* METHOD 1:  iterative
	 * 
	 * we iterate through n values, creating each value from the last two numbers. 
	 * using 3 pointers and a count, updating the pointers along the way.
	 * 
	 * 0   1   1   2
	 * N1  N2  N3
	 *     N1  N2  N3
	 *     
	 * remember we need to loop through n times, so we use a counter
	*/
	
	static void fibonacci_1(int n) {   // n: # of values in in Fibonacci series we would like to print
		
		// variables
		int num1 = 0;
		int num2 = 1;
		int counter = 0;
		
		
		// loop
		while ( counter<n) {
			System.out.print(num1 + " ");
			
			// update pointers
			int num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			
			// update counter
			counter++;
		}
	}
	// time efficiency: we only loop through once, O(N). space efficiency: we don't use any extra DS, just pointers, so O(1)

	/* METHOD 2:   recursive
	 * 
	 * 
	 */
	
	static int fib(int n) {
		// base case
		// we know the answer if we want 1 element = 1
		if (n<=1) {				// add the < because fib2=fib1 + fib0, and fib0 has to give 0
			return n;
		}
		
		// recursion
		return fib(n-1) + fib(n-2);
	}
	
	// time efficiency: tragic, O(2^n)   space efficiency: O(1)
	
	
	// run methods
	
	public static void main(String[] args) {
		
		// iterative method
		System.out.println("method 1: ");
		fibonacci_1(5);
		
		System.out.println("\n\n" + "method 2: ");
		
		// recursive method
		fib(5);
		for (int i=0; i<5; i++) {
			System.out.print( fib(i) + " ");
		}
	
	}
}
