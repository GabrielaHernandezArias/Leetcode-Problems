// UMPIRE

// U: length always >=1, edge case - if length is 1 return false , odd length also false
// M: hashmaps to identify right pair (legend), stacks - add each character of the string to the stack, if it's a CLOSING bracket we can check if the character at the top of the stack matches it 
// if they match, we pop the opening bracket from the stack
// if they don't match, we return false
    // potential edge case - if we start with a closing bracket (would be caught in loop)

// P:
    // build the hashmap, fill it up (have closing brackets as key) - constant space complex.
    // looping through string 
        // for each character, check if it's an opening bracket (NOT in the map)
                // if it's an opening bracket, push into stack
        // else (closing bracket)
            // if top of stack empty - return false. else, do comparison below
            // compare to top of stack (map.value comparison w pop), if no false

// return true :)

class Solution {
    
    public boolean isValid(String s) {
        
        // 1. map
        HashMap<Character,Character> symbols = new HashMap<>();
        symbols.put(')','(');
        symbols.put(']','[');
        symbols.put('}','{');
        
        // 1.5 stack
        Stack<Character> openingSymbols = new Stack<>();
        
        // 2. loop through the string
        for (int i=0; i< s.length(); i++){
            Character symbol = s.charAt(i);
            
            // is it an opening bracket or a closing one?
            if (!symbols.containsKey(symbol)){
                // opening one
                openingSymbols.push(symbol);
            }
            // closing bracket 
            else {
                if (openingSymbols.isEmpty() || symbol!= openingSymbols.pop()){
                    return false;
                }
            }
        }
        
        return true;
    }
}
