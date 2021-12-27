/*
Leetcode #22 - Medium, Generate Parentheses

to find out all combinations of valid parentheses pairs we are going to need ... drumroll..recursion & backtracking!
so we explore all options

example: for n=2 pairs the answer is list answer = [ "(())", "()()"]

so our base case is when the current string is of length == 4 (2 * n)

THREE KEYS TO RECURSION: 
 1- choice
        in each step, do we add a "(" or a ")" ?
 2- constraints 
        we only want valid parentheses pairs, so we can only add a ")" if it has a matching "(". so only add ")" if open > closed
        we can only add open parentheses if they are less than n (we can't add 3 ((( if n=2 )
 3- goal
        to place 2n characters and add to output list answer
 
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output_arr = new ArrayList<>();
        backtrack(output_arr, "", 0, 0, n);
        return output_arr;
    }
    
    public void backtrack(List<String> output_arr, String current_string, int opened, int closed, int max){
        // base case
        if (current_string.length() == max * 2){
            output_arr.add(current_string);
            return;
        }
        
        // recurse
        if (opened < max) backtrack(output_arr, current_string + "(", opened+1, closed, max);
        if (closed < opened) backtrack(output_arr, current_string + ")", opened, closed+1, max);
    }
}
