package main;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Models the state and behavior of a minimum binary heap with an ArrayList
 * @author Matthew F Leader
 *
 * @param <E>
 * 			ideally the thing you want to store in the nodes, but it only uses Integers for now
 */
public class ArrayListMinHeap<E extends Comparable<E>> {
	/** an array list of the heap */
    private List<Integer> array;

    /**
     * Null Constructor
     */
    public ArrayListMinHeap() {
        array = new ArrayList<>();
    }
    
    /**
     * Int array constructor
     * @param array
     */
    public ArrayListMinHeap(int[] array) {
    	this();
    	makeArray(array);
    }
    
    /**
     * Helps construct an ArrayList of Integers from an array
     * of integers
     * @param array
     * 				an array of integers
     */
    private void makeArray(int[] array) {
    	for (int k = 0; k < array.length; k++) {
    		//this.array.set(k, new Integer(array[k]));
    		insert(array[k]);
    	}
    }
    
    /**
     * Size accessor
     * @return the number of elements in the list
     */
    public int size() { 
    	return array.size(); 
    }
    
    /**
     * Whether or not there are any elements in the list
     * @return true if there is at least one element in the list,
     * 			false otherwise
     */
    public boolean isEmpty() {
    	return array.size() == 0;
    }
    
    /**
     * Peek at the minimum priority key stored at the root of the heap
     * @return the minimum priority key
     */
    public int min() {
    	return array.get(0);
    }
    
    /**
     * Append an element to the last position in the array. Bubble it up
     * to an appropriate position in the heap.
     * @param priority
     * 					the priority value of the node
     */
    public void insert(int priority) {
        array.add(priority);
        upHeap(array.size() - 1);
    }

    /**
     * Remove and return the element at the root. Then move the bottom-most,
     * right-most element to the root, and bubble it down to the appropriate
     * position.
     * @return the priority value stored at the root
     */
    public int removeMin() {
        if (isEmpty()) {
        	throw new NoSuchElementException();
        }
        if (!isHeap()) {
        	throw new IllegalStateException("ya broke the heap!");
        }
        int min = array.get(0);
        array.set(0, array.get(array.size() - 1));
        array.remove(array.size() - 1);
        downHeap(0);
        if (!isHeap()) {
        	throw new IllegalStateException("ya broke the heap!");
        }
        return min;
    }


    /**
     * Calculate the index of the parent of a child
     * @param index
     * 				the index of the child
     * @return the index of the parent
     */
    private int parent(int index) { 
    	return (index - 1) / 2;
    }
    
    /**
     * Calculate the index of a left child given the index of
     * its parent
     * @param index
     * 				the index of the parent
     * @return the index of the left child
     */
    private int left(int index) { 
    	return index * 2 + 1; 
    }
    
    /**
     * Calculate the index of a right child given the index of
     * its parent
     * @param index
     * 				the index of the parent
     * @return the index of the right child
     */
    private int right(int index) { 
    	return index * 2 + 2; 
    }

    /**
     * Determine the index of the child with the minimum value for a parent
     * @param parentIndex
     * 					the index of the parent
     * @return the index of the child with the minimum value, -1 if the parent
     * 			has no children
     */
    public int minChildIndex(int parentIndex) {
        if (left(parentIndex) > array.size() - 1) {
        	return -1;
        }
        if (right(parentIndex) > array.size() - 1) {
        	return left(parentIndex);
        }
        if (array.get(left(parentIndex)) <= array.get(right(parentIndex))) {
        	return left(parentIndex);
        }
        return right(parentIndex);
    }

    /**
     * Bubble up the element until it is less than its parent, or
     * it is the root of the heap
     * @param childIndex
     * 				the index of the node
     */
    private void upHeap(int childIndex) {
    	int parentIndex = parent(childIndex);
    	if (childIndex > 0) {
    		if (array.get(parentIndex) > array.get(childIndex)) {
    			swap(parentIndex, childIndex);
    			upHeap(parentIndex);
    		}
    	}
    }

    /**
     * Bubble node down until it less than both of its children
     * @param childIndex
     * 				the index of the node
     */
    private void downHeap(int childIndex) {
    	int minChildIndex = minChildIndex(childIndex);
    	if (minChildIndex > -1) {
    		if (array.get(minChildIndex) < array.get(childIndex)) {
    			swap(minChildIndex, childIndex);
    			// the parent is now at the minChildIndex, so downHeap the value at that index
    			downHeap(minChildIndex);
    		}
    	}
    }
    
    /**
     * Swaps two elements in the list
     * @param i
     * 				the first element
     * @param j
     * 				the second element
     */
    private void swap(int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }
    
    
    public boolean isHeap() {
    	for (int k = 1; k < array.size(); ++k) {
    		if (array.get(parent(k)) > array.get(k)) {
    			return true;
    		}
    	}
    	return true;
    }

}
