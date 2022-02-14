/*

Code from here: https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
Visualization from here: https://www.journaldev.com/44122/tower-of-hanoi

PSEUDOCODE: example n=3 disks (smaller scenario)
                                    A        C           B
method towers (n # of disks, char FROM, char TO, char HELPER)  {

  1. base case
  if n==0, return
  
  2. recursion
  towers ( n-1 , from, helper, to )          we need to move disk 2 from A -> B
  print ( move disk n , from -> to )         disk 3 goes from A -> C
  towers ( n-1 , helper, to, from )          now we move disk 2 from B -> C
  
}

*/ 

public class TowersOfHanoi {

	// method to run               A          C         B
	static void towers(int n, char from, char to, char helper) {
		// base case
		if (n==0) {
			return;
		}
		// recursion
		towers(n-1, from, helper, to);     // moving 2 from A -> B
		System.out.println("move disk " + n + "," + from + " -> " + to);     // move disk 3 from A -> C
		towers(n-1, helper, to, from);     // moving 2 disks from B -> C
 	}
	
	public static void main(String[] args) {
		
		towers(5, 'A','C','B');
	}
}
