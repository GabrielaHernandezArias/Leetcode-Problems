/*

Leetcode hard #239

UMPIRE 
- array nums[] is the input. window size k. find the biggest number in each window and return these in an output array int[]

MATCH
- brute force solution: loop through each window k times but O(N^2) 
- more efficient solution - keep track of biggest and second biggest per window bc we will pop biggest once off-limits (window) so we use a deque (we can pop off/ add from both ends on O(1) time)

PLAN
- loop through entire array once (until R < length of nums[]) 
- as we loop, set pointers L and R to 0 
- declare output [] and deque [] structures, deque has indexes 
- while (R is > top right of deque && deque is not empty, pop top right of deque) 
- add R to deque top right 
- once L out of bounds, pop top left of deque if it's larger than L 
- once R reaches length of window, we start appending the top left value of dq to output [], and L++ 

*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // 0. declare variables
        int L=0; int R=0;
        int ogLength = nums.length;
        int[] output = new int[ogLength-k+1];   // output array
        Deque<Integer> deq = new LinkedList<Integer>();   // to store indexes of max #s. monotonically decreasing queue
        
        // 1. loop through entire array
        while (R < ogLength){
            
            // 2. while nums R is > top right of deque, pop deque, if not empty
            while ( !deq.isEmpty() && nums[R] > nums[deq.peekLast()] ){
                deq.removeLast();
            }
            // 3. if nums[R] is less than deque, or if deque is empty, add to deque.
            deq.addLast(R);
            
            // 5. once R reaches length of window, append R to topLeft of output[] and L++
            if (R+1 >= k){
                output[L] = nums[deq.peekFirst()];   // adding to output array the biggest element of the deque
                L++;
            }
            
            // 6. L has been ++, if L that is now out of bounds is top left of deq, pop top left
            if (L-1 == deq.peekFirst()){
                deq.removeFirst();
            }
            R++;
        }
        return output;
    }
}
