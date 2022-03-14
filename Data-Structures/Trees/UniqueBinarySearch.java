/*
# 96 - Unique Binary Search Trees. --> COME BACK TO THIS ONE! dynamic programming

PROBLEM:
- we receive a number n
- we want to know how many structurally unique BST's with n nodes with values from 1 to n we can make
- values 1-n, don't repeat 
- structurally unique: parent / children
- Binary: 2 children per node? no, example 1. so: not balanced 
- SEARCH: greater than parent goes to right, lesser than parent goes to left
- n <= 19

SOLUTION 1:
we are going to have to create these options, store an int n on valid options 
explore all combinations - recursion?

SOLUTION 2:
rather than using recursion, we can use dynamic programming and memoization 
"base case" when just one node: we just have one possible tree

after looking at combinations, we can see a pattern:
we add up the possible sub-tree combinations if each n element was the root
so in n(2) for root 1, we have 0 subtrees to the left, and 1 to the right (2-node)

n(2)    1 2
= n(0) n(1) + n(1) n(0) = 1 + 1 = 2

n(3)    1 2 3
we explore 1 as a root, then 2, then 3 and add up the possible combos
= n(0) n(2) + n(1) n(1) + n(2) n(0) = 1*2 + 1*1 + 2*1 = 2 + 1 + 2 = 5

PLAN:
- declare an array size 0 to n + 1
- array index will be tree node, array element will be number of possible combos for that subtree
- to get n we just return the element in the array we will have already filled in

*/ 

class Solution {
    
    public int numTrees(int n) {
        // memo array
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        
        // loop through
        // for example for n=3, we need subtrees 0,1,and 2
        // 
        for (int numTrees=2; numTrees <=n; numTrees++){
            // for example: from 0 to less or = 3
            // n is 3, we stop i <= 3
            // first your root is 1, then root is 2 then root is 3 
            
            for (int root=1; root <= numTrees; root++){
                arr[numTrees] = arr[numTrees] + arr[numTrees-root] * arr[root-1];
            }
        }
        
        return arr[n];
        
    }
    
}

// debug, print the following within inner loop: 
// System.out.println("root " + root);
// System.out.println("for i: "+i+", we add arr[i]: "+arr[i]+" +  i-root: "+(i-root)+" arr "+arr[i-root]+" root-1: "+(root-1)+" arr "+arr[root-1]);
// big o is o(n^2) and space complexity o(n) :)
