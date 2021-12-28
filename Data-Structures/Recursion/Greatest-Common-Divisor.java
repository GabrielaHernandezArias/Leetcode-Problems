/*
Leetcode # 1979 - easy

we find the smallest number, and then the largest number in nums
then we use recursion to apply euclid's algorithm to both of these numbers
this returns the largest common divisor :D

any edge cases? nope because for this leetcode nums.length is always <= 2

TIME AND SPACE COMPLEXITY:
euclid: faster than 38% java, uses less memory than 97% of java submissions
other iterative solutions: faster than 100% of java, uses less memory than 30%

*/

class Solution {
    
    // 1. regular method
    public int findGCD(int[] nums) {
        // find largest and smallest in nums - can we sort? that way we find these two numbers 
        // in a more efficient time than O(n) (if we looped through the entire array once)
        Arrays.sort(nums);
        
        int smallest = nums[0];
        int largest = nums[nums.length-1];
        
        // now we have a and b - on to euclid, my man! 
        return euclid(smallest, largest);
    }
    
    // 2. recursive method
    public int euclid (int a, int b){
        // base case
        if (b==0) return a;
        
        // recursion 
        else return euclid (b, a % b);
    }
    
}
