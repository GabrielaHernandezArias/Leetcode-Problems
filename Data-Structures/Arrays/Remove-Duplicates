/*  5:11 to 6:11 pm, UMPIRE
    10:30 pm

U: integer array, sorted in ascending order. remove duplicates IN PLACE
    place the result in first part of array
    only return the first elements with the answer
    use O(1) extra memory
    
    1, 1, 2
    answer : 1, 2
    k = 2 (number of items left after removing duplicates)
    
    [0,0,1,1,1,2,2,3,3,4]
    answer: [0,1,2,3,4,_,_,_,_,_]

M: match

    since i can't use extra memory, a two-pointer approach would be best. a hashmap would be more time efficient but a two pointer approach is more memory-efficient :)

    to make it more efficient, we won't have the second pointer go through ALL the array, just the next couple of elements until the element is different 

    how will we delete and MOVE all elements? if we scoot over all elements after a duplicate to the left and add the duplicate to the end that's a HUGE o(n) time baggage. wait but they don't need to be stored. but we do have to shift all of them right? ugh

P: plan
    
    loop through array. if next element is equal, keep going. once you encounter a unique next element, add it to the element.next and so on

I: implement - done! 

R: review (run through it) - tis not running tho lol

E: evaluate efficiency

*/

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i=0;   // pointer 1
        
        for (int j=1; j< nums.length; j++){  // pointer 2 is j
            
            if (nums[i] != nums[j]){         // if i and j are DIFFERENT (not duplicates)
                nums[i+1] = nums[j];        // make i+1 = j
                i++;                        // advance i
            }
        }
        
        return i+1;

    }
}
