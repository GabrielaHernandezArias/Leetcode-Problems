/* 

Leetcode N.13 Roman To Integer

UMPIRE 

GH. Oct 13, 2021 

NOTE: java hashmap .get(key) - returns value from key 

U - notes: roman #s written from largest to smallest from left to right UNLESS IT'S AN EXCEPTION (four: IV) 
    so to solve we could read from left to right checking that i > j and add unless it's not, then subtract j-i 
    
M - match w a data structure. it would be useful to have a hashmap so we can store the # equivalent to all letters so we can perform all the operations 

P - plan: 

    N/A | exceptions: empty string, return null - not a case, bc all s are valid 
    
    set up hashmap w/ keys. keys are the letters and values are the equivalent #s 
    
    declare value int total = 0; 
    read (loop) checking that i>j 
            IF YES: add value of key(i) to total 
            IF NOT: add subtraction of key(j) - key(i) to total, and skip one # (j) when looping 
    finish loop of string
    
    return int total

I - implement 

*/

class Solution {
    public int romanToInt(String s) {
        
        // 1. set up hashmap
        HashMap<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        
        // 2. variables
        int total = 0;
        
        // 3. loop
        for (int i=0; i < s.length(); i++) {
            
            // if last character, add to total bc otherwise out of bounds
            if (i == s.length()-1){
                total = total + romanMap.get(s.charAt(i));
            }
            
            // else if i>j (normal), add to total
            else if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i+1))) {
                total = total + romanMap.get(s.charAt(i));
            }
            // else, subtract j-i and add that to total, and skip one
            else {
                int temp = romanMap.get(s.charAt(i+1)) - romanMap.get(s.charAt(i));
                total = total + temp;
                i++;   // skip one i
            }
        }
        
        // 4. return total
        return total;
    }
}

/*

Review - looped through with an example
Evaluate - big o of O(N) because we only loop through once. space complexity of O(N) because we use an extra ds: hashmaps, but according to the size of the string. so it's not a constant but it's just a linear space complexity

*/
