/*
LEETCODE #706 

okay you know how for hashsets we used an array of linked lists, and each array index was a hash value, and the linked lists were used to handle collisions. so we could have several nodes in the same linked list that had the same hash value

a difference between hashsets and hashmaps is that hashmaps have keys and values, while hashsets only have values 

so for hashmaps, we are going to use an array of linked lists but instead of being like linked lists of integers, they will be linked lists of a class called entry(key, value) 

https://github.com/Algorithms-Made-Easy/March-Leetcoding-Challenge/blob/main/7.%20Design%20HashMap

*/

class MyHashMap {
    
    // variables we need
    public static int NUMBUCKETS = 769;
    LinkedList<Entry>[] arrBuckets;       // an array of linked lists. the linked lists are of type entry

    // method 1: initializing hashmap
    public MyHashMap() {
        arrBuckets = new LinkedList[NUMBUCKETS];
    }
    
    // extra - method 2: determining hash value
    public int hashVal(int key) {
        int hash = key % NUMBUCKETS;
        return hash;
    } 
    
    // method 3: put key/val into hashmap. if bucket is null, initialize. if bucket is not null, and already contains the element then delete the current element. add new element to bucket
    public void put(int key, int value) {
        // hash - in what bucket would it be?
        int i = hashVal(key);
        
        // if bucket is null, initialize
        if (arrBuckets[i] == null) arrBuckets[i] = new LinkedList<Entry>(); 
        // if bucket is not null (else) and value is already present, update value
        else {
            // loop through - check that if key is already present, update the value
            for (Entry entry: arrBuckets[i]){
                if (entry.key == key) {
                    entry.val = value;
                    return;     // break out of whole method
                }
            }
        }
        arrBuckets[i].add(new Entry(key,value));
    }
    
    // method 4: if bucket is not null and contains the key, return value. return -1
    public int get(int key) {
        // in which bucket would this key be?
        int i = hashVal(key);
        
        // if that linked list is null, there will be no value so return -1
        if (arrBuckets[i] == null) return -1;
        // if bucket is not null, loop through list. if element == key, return val
        for (Entry entry : arrBuckets[i]) {
				if(entry.key == key) return entry.val;
		}
        return -1;
    }
    
    // method 5: if bucket is not null, loop through
    public void remove(int key) {
        // in which bucket would this key val pair be?
        int i = hashVal(key);
        
        // if bucket is null, return
        if (arrBuckets[i]==null) return;
        // to avoid the concurrent modification exception
        Entry entryRemove = null;
        
        // if bucket is not null, loop through, and remove
        for(Entry entry : arrBuckets[i]) {
				if(entry.key == key){
                    entryRemove = entry;
                } 
		}
        if (entryRemove != null) arrBuckets[i].remove(entryRemove);
    }
}

class Entry{
    public int key;
    public int val;
    
    public Entry(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
