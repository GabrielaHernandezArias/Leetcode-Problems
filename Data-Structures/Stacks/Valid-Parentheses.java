/*

Leetcode #20, Easy, Valid Parentheses

UNDERSTAND
    - open brackets MUST be closed by same ones in correct order
    - we can have brackets within brackets
    - hash map - check that same number of open as closed, BUT ORDER
    - for order, array or stack. we could save the string in an array and have two pointers comparing, one from beginning and one from end. if they meet, true
    - but space complexity - if we use a stack and compare the 

MATCH 
    - stack: first in last out. we can have two stacks. first add everything to stack 1. then pop off into stack 2 until halfway through. then, pop off both and compare. oh god we'll need a hashmap too first to actually be able to compare that we are dealing with the pair of the value since they arent actually equal but pairs
    
    - if stack doesn't work, we can use a deque. and as we compare, we delete them so by the end the space complexity will be of O(1). honestly i feel like we should use a deque but oh well

PLAN
1. edge cases - empty string. var = string length
2. populate hashmap with pairs
3. add all of string to S1 (stack 1)
3. loop through S1 until less than half of string length adding to S2
4. check if pop S1 == S2, if not = false
    - and by =, i actually mean if S2.pop is the value of S1.pop key
5. else, true

IMPLEMENT
ok but i sincerely feel like a deque would be smarter.

incorrect assumption: we would always have pairs. had to fix for test case ")(){}"

OKAY SO THIS DID NOT WORK. 

Approach #2:
1. turn string into character array
2. as we loop through character array, add the opposite of (, {, and [ to the stack (so: ) } ])
3. if the element in the character array is not equal to the stack (we are closing a diff parentheses) or if the stack is empty (we are just closing and never opening), return false
4. return stack.isEmpty (stack should be empty if all parentheses were closed)

Big o is O(N) since we only loop through the character array once 
Space complexity is O(N) as well because the worst case scenario would be all ((((( so the stack would be )))))
*/

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
