/*

# 231 Power of Two - come back and do this again with the n-1 trick :)

- receive an int n, return true IF power of 2
- if there is an integer x such that n == 2^x

example:
n = 1
is 1 a power of 2?
2^x = 1

constraints:
x <= 31

APPROACH 1
brute force: with loops, we loop until we reach the 2^x = n integer. worst-case scenario x is 31 so we loop through 2^0 - 2^31 or even worse, we never find it and we looped through the entire thing

APPROACH 2
since we only need to return true or false
really, even if we needed to return the answer
memoization - store 1-31 (value) and 2^value (key)  - get(key)
            - we receive n (16) if key exists, return (value)
            - we don't really need to return any of these so we could just build a LIST 2^1-31, then just for runtime check if it contains. this would be o(n) time since 1-31 constant. .contains is constant
            
APPROACH 3
just to practice, then solve this using recursion

*/

import java.lang.Math;


class Solution {
    public boolean isPowerOfTwo(int n) {
                
        // fill in hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // constant time 
        // keys:  1. 2. 4. 8. 32.  (2^i) ... 2^31-1
        // value: 0, 1, 2, 3, 4  (i) ...31
        
        for (int i=0; i< 31; i++){
            int key = (int)Math.pow(2,i);
            map.put(key,i);
           // debug: System.out.println("key: " + key + " value: " + i);
        }
              
        // now having the map already, we check if our int n is in the map
        if (map.containsKey(n)){
            return true;
        }
        
        return false;
    }
}

/*
example: 3
map - OH IT CONTAINS ALL KEYS

example: 1
keys 1, 2, 4, 8...
containsKey(1) is should be true

the issue was that math.pow gives you a double, so we need to typecast to integer
int val = (int)Math.pow(2,power);
*/
