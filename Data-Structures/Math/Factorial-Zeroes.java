/*
Leetcode #172 - factorial trailing zeroes, medium

Since n can go up to 10^4 - 10,000, we shouldn't use recursion because the call stack would be too deep. also, to find the number of ending zeroes, finding the factorial would be an innecessary calculation

a factorial is 5! = 5 x 4 x 3 x 2 x 1 = 120 - one trailing zero because the multiplication has one 5

10 ! = 10 x 9 x 8 x 7 x 6 x 5 x 4 x 3 x 2
     = ( 5 x 2) x 9 x 8 x 7 x 6 x (5) x 4 x 3 x 2
     answer = 2

10 / 5
= 2

25 !  = 25 x 24 x 23 x 22 x 21 x 20 x 19 x 18 x 17 x 16 x 15 x 14 x 13 x 12 x 11 x 10
      = (5 x 5) x (5 x 4) x (5 x 3) x 5 x 5
      answer = 6
      
25 / 5 = 5
5/5 = 1
= 6

so we can't just divide by 5 once, we need to keep dividing in case we have something like 25
      
math explanation: trailing zeroes are caused by multiplying a number x 10
                  we would have to look for occurrences of 2 and 5 within n!
                  testing examples, n! has way more 2! than 5!, so we only need to look for occurrences of 5 since we will always have a corresponding 2

good explanation: https://www.youtube.com/watch?v=3Hdmv_Ym8PI

*/

class Solution {
    
    public int trailingZeroes(int n) { 
        int r = 0;
        
        while (n > 0) {
            n /= 5;             // n = n/5   if the answer is 1.4 or 1.7, n will only store 1
            r += n;
        }
        return r;
    }
    
}

/*

EVALUATE

time complexity is o(log n)
space complexity is constant o(1) because no significant extra data structures are used

REVISE SOLUTION

example: trailing zeroes for 6! = 720 ... 1

trailingZeroes (6)

1. int r = 0, while 6>0
        n = 6/5 = 1.2 = 1
        r = 0 + 1 = 1
        
2. int r = 1, while 1>0
        n = 1/5 = 0.2 = 0
        r = 1 + 0 = 1

3. r = 1, n = 0 so n is not > 0

example: trailing zeroes for 10! = 3628800 ... 2

trailingZeroes (10)

1. int r = 0, n = 10
        n = 10 / 5 = 2
        r = 0 + 2 = 2

2. r = 2, n = 2
        n = 2/5 = 0.4 = 0 - loop will stop here
        
trailingZeroes (25) = 15511210043330985984000000 ... 6

1. r = 0, n = 25
        n = 25 / 5 = 5 
        r = 5

2. r = 5, n = 5
        n > 0
        n = 5/5 = 1
        r = 6

*/
