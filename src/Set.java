/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoLab;

/**
 *
 * @author Erdur
 */
// The set class uses a hash table as the internal data structure.
public class Set<T> {
    // Uses the generic LinkedList3 class from Display 15.8

    private LinkedList3[] hashArray;
    private int size = 10;		// This is now a settable parameter

    public Set() {
        hashArray = new LinkedList3[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new LinkedList3<T>();
        }
    }

    public Set(int initialSize) {
        size = initialSize;
        hashArray = new LinkedList3[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new LinkedList3<T>();
        }
    }

    /**
     * Add a new item to the set. If the item is already in the set, false is
     * returned, otherwise true is returned. Requires that T implement
     * toString() correctly.
     */
    public boolean add(T newItem) {
        int hash = computeHash(newItem.toString());	// Get hash value
        LinkedList3 list = hashArray[hash];
        if (!list.contains(newItem)) {
            // Only add the target if it's not already
            // on the list.
            hashArray[hash].addToStart(newItem);
            return true;
        }
        return false;
    }

    /**
     * Returns true if item is in the set, false otherwise. Requires that
     * toString be defined.
     */
    public boolean contains(T item) {
        int hash = computeHash(item.toString());
        LinkedList3 list = hashArray[hash];
        if (list.findData(item) == null) {
            return false;
        }
        return true;
    }

    /**
     * Outputs the entire contents of the hash table.
     */
    public void output() {
        for (int i = 0; i < size; i++) {
            LinkedList3 list = hashArray[i];
            if (list != null) {
                list.outputList();
            }
        }
    }

    /**
     * Returns a new set that is the union of this set and the input set.
     */
    public Set<T> union(Set<T> otherSet) {
        Set<T> unionSet = new Set<T>();
        // Copy this set to unionSet
        for (int i = 0; i < size; i++) {
            LinkedList3 list = hashArray[i];
            LinkedList3<T>.Node<T> iter = list.getHead();
            while (iter != null) {
                unionSet.add(iter.getData());
                iter = iter.getLink();
            }
        }
        // Copy otherSet items to unionSet.
        // The add method eliminates any duplicates.
        for (int i = 0; i < size; i++) {
            LinkedList3 list = otherSet.hashArray[i];
            LinkedList3<T>.Node<T> iter = list.getHead();
            while (iter != null) {
                unionSet.add(iter.getData());
                iter = iter.getLink();
            }
        }
        return unionSet;
    }

    /**
     * Returns a new that is the intersection of this set and the input set.
     */
    public Set<T> intersection(Set<T> otherSet) {
        Set<T> interSet = new Set<T>();
        // Copy only items in both sets
        for (int i = 0; i < size; i++) {
            LinkedList3 list = hashArray[i];
            LinkedList3<T>.Node<T> iter = list.getHead();
            while (iter != null) {
                if (otherSet.contains(iter.getData())) {
                    interSet.add(iter.getData());
                }
                iter = iter.getLink();
            }
        }
        return interSet;
    }

    /**
     * Compute a simple hash function
     */
    private int computeHash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
        }
        return hash % size;
    }
    
    public Set<T> Fark(Set<T> otherSet) {
        Set<T> FarkSet = new Set<T>();
        for (int i = 0; i < size; i++) {
            LinkedList3 list = hashArray[i];
            LinkedList3<T>.Node<T> iter = list.getHead();
            while (iter != null) {
                if (otherSet.contains(iter.getData())) {
   
                }
                else{
                    FarkSet.add(iter.getData());
                }
                iter = iter.getLink();
            }
        }
        return FarkSet;
    }

} // Set

