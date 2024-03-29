/* a hashset is an unordered set of elements (doesn't maintain insertion order). no duplicates are allowed
on the other hand, treesets are unordered BUT the are sorted in ascending order

to build a hashset we will use an array of linked lists. each index in the array will have a linked list. this method of dealing with collisions is called separate chaining. 

we will have the following methods: initializing hashet, hash, add, remove, and contains

note - if i could i would name key value because it's actually a value. hashset only has values. hashmap is the one that has key-value pairs
*/

class MyHashSet {

    // variables we need
    List<Integer>[] bucketArr;            // array of linked lists, i know, it looks funky
    private int numBuckets = 10000;                     // number of indexes in array
    
    // method 1: calculate hash value
    public int hashValue(int key) {
        return key % numBuckets;
    }
    
    // method 2: initialize hashset
    public MyHashSet() {
        bucketArr = new LinkedList[numBuckets];
    }
    
    // method 3: add to hashset
    public void add(int key) {
        // hash index -> in which bucket should this element be?
        int i = hashValue(key);
        
        // if there is no list in that index, initialize a list
        if (bucketArr[i]==null) bucketArr[i] = new LinkedList<>();
        
        // if there is a list and the element is NOT THERE already (bc no duplicates), add to list
        // this is not an else if because both conditions can be true - we initialize AND add
        if (bucketArr[i].indexOf(key) == -1){
            bucketArr[i].add(key);
        }
    }
    
    // method 4: remove element from hash set 
    public void remove(int key) {
        // hash index of this element - where should it be stored already?
        int i = hashValue(key);
        
        // if linked list in this bucket contains this element, remove it 
        if (bucketArr[i]!=null && bucketArr[i].indexOf(key) != -1) {
            // if we don't add != null, we get a nullpointerexception
            bucketArr[i].remove(bucketArr[i].indexOf(key));
        }
    }
    
    // method 5: does the hash set contain this element
    public boolean contains(int key) {
        // hash index where this element would be stored
        int i = hashValue(key);
        // in this index, if linked list index of element != -1, then the list contains the element
        if (bucketArr[i] != null && bucketArr[i].indexOf(key) != -1) return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
