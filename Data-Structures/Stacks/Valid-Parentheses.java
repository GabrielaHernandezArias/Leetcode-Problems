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
    
	Stack<Character> stack = new Stack<Character>();
	
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
    
	return stack.isEmpty();
    
    }
}
