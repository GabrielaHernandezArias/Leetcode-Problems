/* 

Leetcode # 912 

Sort an array in ascending order. We will use this opportunity to implement quicksort!

Quicksort sees an array, locates a pivot (at random, to maintain o(n log n) time) and swaps elements within the partition range, the pivot swaps places with the pointer and so at the end of each iteration

Then we call quicksort on both the left and the right partitions of pivot until we reach the base case: there is only ONE element within the partition being called

I shall come back and optimize this approach - currently at a runtime of 30 ms, faster than 33% of java. memory 62 MB, less than 25%

*/ 

class Solution {
    
    public int[] sortArray(int[] nums) {
        return quickSort(nums, 0, nums.length-1);
    }
    
    // 1. recursive method
    public int[] quickSort(int[] arr, int start, int end){

        // recurse: if array is more than one element, quicksort both left and right partitions
          // get pivot
        if (end-start >= 1) {
        int partition = sort(arr, start, end);
        
        quickSort(arr, start, partition);
        quickSort(arr, partition+1, end);
        }
        
        return arr;
    }
    
    // 2. swap method
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    // 3. find pivot method
    public int findPivot(int min, int max){
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }
    
    /* 4. sorting method  
              finds pivot value, places it to the end of the range 
              
              compares each element in the range to the pivot value and swaps the items 
              with the pivot index if the items are less than the pivot value, then moves pivot index to the right
              at the end of the loop, all items less than pivot are to the left of the pivot index
              
              end of loop: swap pivot index with pivot (currently at the right end of the range)
              
              method returns pivot index
              
              5.   8.   2.   3
            s/pI             p
    */
    
    public int sort(int[] arr, int start, int end){
       // find pivot value
        int pivot = findPivot(start, end);
        // place pivot at the end of the sorting range
        swap(arr, end, pivot);
        
        // pivot index starts out at the start
        int pivotIndex = start;
        
        // loop through start to (end -1) and make appropriate swaps
        for (int i= start; i<= end-1; i++){
            if (arr[i] < arr[end]) {    // comparing current and pivot (pivot is in start)
                // swap with pivot index, increase pivot index
                swap (arr, i, pivotIndex);
                pivotIndex++;
            }
        }
        // once loop is done, swap pivot index with pivot
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }
}
