/*
Leetcode # 567 - Permutation in string, medium

UNDERSTAND - two strings. return true if s2 contains a permutation of s1 (if one of s1's permutations is a substring of s2). do we have to calculate all permutations? probably not. should i learn to do this though? yessir

... how would i compute all permutations of a string? sounds a lot like recursion! 


okay but we don't actually need to calculate all the permutations of a string for this problem - we can use a sliding window in s2 and check if the frequencies of the characters are the same in s1 and the s2 window

MAP - no extra DS needed
PLAN -

0. edge case - if s1 is longer than s2 return false
1. initialize two int arrays size 26 with all letters. s1map and s2map. 
2. fill array frequency for s1map with s1, and array frequency for s2map window #1
3. keep looping through string 2, and move window
4. write function that compares both s1 and s2 arrays

IMPLEMENT:
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 0. edge case
        if (s1.length() > s2.length()) return false;
        
        // 1. initialize s1map and s2map
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        
        // 2. fill array frequency for s1map: loop through string 1 adding char to s1map
        for (int i=0; i< s1.length(); i++){
            s1map[s1.charAt(i) - 'a'] ++;    // increase frequency of this s1 letter in s1map
            // s2 window 1 
            s2map[s2.charAt(i) - 'a'] ++;    // increase frequency of this s2 letter in s2map
        }
        
        // 3. compare two maps and also move sliding window and keep comparing
        for (int i=0; i< s2.length() - s1.length(); i++){
            
            if (compareArrs(s1map, s2map)) return true; 
            
            // move sliding window (both in string 2 and in s2map)
            s2map[s2.charAt(i) - 'a'] --;   // remove letter leaving window from s2map
            s2map[s2.charAt(i+ s1.length()) - 'a'] ++;    // add new letter entering window to s2map
            
        }
        
        // if there was a permutation, then it would have been found in step #3
        return compareArrs(s1map, s2map);
        
    }
    
    // method that compares two maps
    
    public boolean compareArrs(int[] arr1, int[] arr2){
        for (int i=0; i< arr1.length; i++){
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}

/*
REVIEW - time complexity is o(n) since we loop through each string separately , no inner loops
        space complexity is o(1), constant, since we use a fixed 26-size array
EVALUATE - i looped through a couple of examples
*/
