/*
Leetcode # 344 - Reverse String

UNDERSTAND - a function that reverses a string. input is an array of characters. do this in-place without extra memory
        
MATCH - in place: a greedy approach. start two pointers, beginning and end, swap until they meet

uneven:
h e l l o
o l l e h

even:
r o s e

PLAN
  loop through character array until ! (pointer A < pointer B)
  in each loop, swap pointer A with pointer B's character
  return reversed string char? 
  
IMPLEMENT
*/

class Solution {
    public void reverseString(char[] s) {
        
        // 1. declare pointers
        int A = 0;
        int B = s.length-1;
        
        // 2. loop through char array and swap until a !< b
        while (A<B) {
            // swap 
            Character temp = s[A]; 
            s[A] = s[B];
            s[B] = temp;
            // advance pointers
            A ++;
            B --;
        }
        
        // return s;
    }
}

/*
REVIEW - any edge cases? work through them
    char array always length of at least 1, would just return the one character
    checked even and odd 
    always valid input

EVALUATE - big o, space? 
    we loop through the entire data set once so the time complexity is O(n)
    the space complexity is in fact O(1) constant since no extra ds are used at all
    
Ok this was easy and dare i say ... fun?! :D
*/
