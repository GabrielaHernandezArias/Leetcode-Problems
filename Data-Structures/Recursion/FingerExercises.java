
/*
 * CIS 110 UPenn Exercises
 * 
 * Practicing some homework from UPenn to better understand recursion
 * https://www.seas.upenn.edu/~cis110/current/homework/sierpinski.html
 * 
 */

public class FingerExercises {

	// EXERCISE 1: Palindrome
	
	public static boolean isPalindrome(String word) {

	    // base case - length is 0 or 1, and therefore is a palindrome
	    if (word.length() <= 1) {
	        return true;
	    }

	    // check if first and last are the same
	    char firstChar = word.charAt(0);
	    char lastChar = word.charAt(word.length() - 1);
	    
	    boolean firstAndLastMatch = firstChar == lastChar;

	    // if they match, recurse on the string without the first and last letters
	    return firstAndLastMatch && isPalindrome(word.substring(1, word.length() - 1));
	}
	
    // how could we have solved this with a helper method? yes but like, very inefficiently
	
	/* EXERCISE 2: Cumulative sum
	 * 
	 * public static int sumBetween(int a, int b)
	 * The goal is to find the sum of the values from 𝑎 to 𝑏. In math, we would write this problem as ∑𝑏𝑖=𝑎𝑖
	 */
	 
	 public static int sumBetween(int a, int b) {
		 return sumBetweenHelper(a, b, 0);
	 }
	 
	 public static int sumBetweenHelper(int a, int b, int ans) {
		 // base case
		 if (a==b) {
			 ans = ans +b;
			 return ans;
		 }
		 // recursion
		 ans = ans + a + b;
		 return sumBetweenHelper(a+1, b-1, ans);
	 }

	 /* EXERCISE 2.1
	  * Now, write another method to find the sum of values from 1 to 𝑥
	  * Think about how you can take advantage of prior code to solve this problem.
	  */
	 
	 // example sumTo(4) = 4 + 3 + 2 +1
	 
	 public static int sumTo(int x) {
		 return sumToHelper(x, 0);
	 }
	 
	 public static int sumToHelper(int x, int ans) {
		 // base case, when x is 1
		 if (x==1) {
			 ans = ans + 1;
			 return ans;
		 }
		 // else, recursion!
		 ans = ans + x;
		 x--;
		 return sumToHelper(x, ans);
	 }
	 
	 /* EXERCISE 3
	  * Given an array of integers, find the second largest value in the array
	  * 
	  * [2, 2, 1] returns 2
	  * [2, 5, 1, 3, 7] returns 5
	  * [3, 5, 1] returns 3  
	  */
	 public static int findSecondLargest(int[] nums) {
		    return findSecondLargestHelper(Integer.MIN_VALUE, Integer.MIN_VALUE, 0, nums);
		    // integer min value will be updated as soon as we find a larger value
		}

	 public static int findSecondLargestHelper(int largest, int secondLargest, int index, int[] nums) {
		 // base - when the index reached the last # in the array
		 if (index == nums.length) {
			 return secondLargest;
		 }
		 // else, compare the current new index and recurse
		 if (nums[index] > largest) {
			 secondLargest = largest;
			 largest = nums[index];
		 }
		 index++;
		 return findSecondLargestHelper(largest, secondLargest, index, nums);
	 }
	 
	 /* EXERCISE 4
	  * 
	  * Sum Of Digits
	  * sumOfDigits(146) would give 1+4+6
	  */
	 public static int sumOfDigits(int x) {
		 String str = Integer.toString(x);
		 return sumOfDigitsHelper(str, 0, 0);
	 }
	 
	 public static int sumOfDigitsHelper(String str, int index, int ans) {
		 // base case : when we iterated through all #s hence index == length
		 if ( index == str.length()) {
			 return ans;
		 }
		 
		 int toAdd = Integer.parseInt(String.valueOf((str.charAt(index))));
		 ans = ans + toAdd;
		 
		 // else, recurse keep adding
		 index++;
		 return sumOfDigitsHelper(str, index, ans);
	 }
	 
	 /* EXERCISE 5
	  * 
	  * Count Ways to Climb Stairs
	  * 
	  * Given an amount of stairs to climb, calculate the number of ways to climb taking either 1 or 2 steps at a time. 
	  * For example, if there are 4 stairs, we would return 5, as there are the following options:
	  * 1 1 1 1
	  * 1 1 2
	  * 1 2 1
	  * 2 1 1
	  * 2 2
	  * 
	  * WORKING OUT --------------------------------
	  * we can do two things: add a 1 or add a 2
	  * the base case will be when the sum == 4 
	  * for each base case, we add one to ans 
	  * 
	  * base: if (sum == 4) 
	  * 	ans ++ 
	  * 	return
	  * 
	  * recurse:
	  * 	add 1		- this should end first in 1 1 1 1, then move to 1 1 2
	  * 	add 2
	  * 
	  */
	 
	 public static int countWays(int stairs) {
		 return countHelper(stairs, 0);
	 }
	 
	 public static int countHelper(int sumNeeded, int currentSum) {
		    
		 // base - we will reach this base multiple times
		    if (sumNeeded == currentSum) {
		        return 1;
		    } 
		    
		    else if (currentSum > sumNeeded) {
		        return 0;
		    }
		    
		    // recurse - add 1 and then add 2
		    int possibleCombos = 0;
		    
		    possibleCombos += countHelper(sumNeeded,currentSum + 1);
		    possibleCombos += countHelper(sumNeeded,currentSum + 2);
		    
		    return possibleCombos;
		}
	 
	 /* EXERCISE 7
	  * 
	  * Count how many times a specific substring appears in a word
	  * For example, how many times does "na" appear in "banana"? 2 times :)
	  * 
	  * can we do this without a helper method? we have to have learned something from exercise 5! 
	  */
	 
	 // this code is courtesy of @azro, stackoverflow. an EFFICIENT solution. 10/10
	 
	 public static int countSubstrings(String str, String sub) {
		    if (str.contains(sub)) {
		        return 1 + countSubstrings(str.replaceFirst(sub, ""), sub);
		    }
		    
		    return 0;
	} 
	 		
	 // run methods 
		
		public static void main(String[] args) {
			
			// # 2 - cumulative sum
			System.out.println(sumBetween(2,4));   // 9
			
			System.out.println(sumBetween(1,3));   // 6
			
			System.out.println(sumBetween(3,7));  // 25
			
			System.out.println(sumTo(4));  // 10
			
			System.out.println(sumTo(10));  // 55
			
			int[] nums = {0, 3, 2, 5, 9};
			System.out.println(findSecondLargest(nums));  // 4
			
			System.out.println(sumOfDigits(123));  // 6
			
			System.out.println("ways to climb 4 stairs: " + countWays(4));  // 5
			
			// substring
			String str = "word";
			//            0123 
			
			System.out.println("substring 0-2 is: wo " + str.substring(0,2));
			
			System.out.println(countSubstrings("banana","na"));  // 2
		}
}
