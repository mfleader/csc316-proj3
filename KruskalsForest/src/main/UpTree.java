package main;



/**
 * This UpTree class models the state and behavior of a union-find structure
 * that maintains disjoint sets. Each node is represented by an integer, so it
 * can be is represented by an index position in the array. At each position, 
 * if the integer is greater than -1, then the value stored there is that child's
 * parent. If the value is less than or equal to -1, then that node is a root,
 * and the absolute value stored there equals the number of nodes in that root's
 * tree.
 * 
 * @author Matthew F. Leader
 *
 */
public class UpTree {
	
	/** an array of Integers that correspond to the priority of a node */
	private Integer[] array;
	/** the maximum possible capacity expected for this uptree */
	private static final int CAPACITY = 5000;
	
	/**
	 * UpTree constructor
	 * @param capacity
	 * 					expected capacity for this uptree
	 */
	public UpTree(int capacity) {
		array = new Integer[capacity];
	}
	
	/**
	 * UpTree null constructor
	 */
	public UpTree() {
		this(CAPACITY);
	}
	
	/**
	 * UpTree constructor when you have an array of ints
	 * @param array
	 * 					an array of ints
	 */
	public UpTree(int[] array) {
		this.array = new Integer[CAPACITY];
		for (int k = 0; k < array.length; k++) {
			makeSet(array[k]);
		}
	}
	
	/**
	 * Make a new set with the given key as the representative (root) of
	 * that set
	 * @param key
	 * 					the given key
	 */
    public void makeSet(int key) {
    	array[key] = new Integer(-1);
    }
    
    /**
     * Find the representative (root) at the head of this set by following
     * parent pointers
     * @param key
     * 					the given key to investigate
     * @return the root of this UpTree
     */
    public Integer find(int key) {
    	while (parent(key) != null) {
    		key = parent(key);    		
    	}
    	return key;
    }
    
    /**
     * The parent of this child
     * @param key
     * 					the child's index in the array
     * @return the index of this child's parent
     */
    public Integer parent(int key) {
    	if (array[key] > -1) {
    		return array[key];
    	}
    	return null;
    }
    
    /**
     * Merges the clusters containing root nodes s and t
     * @param s
     * 				the root of a set
     * @param t
     * 				the root of a set
     */
    public Integer union(Integer s, Integer t) {
    	if (Math.abs(array[s]) >= Math.abs(array[t])) {
    		array[s] += array[t]; 
    		array[t] = s;    		
    		return s;
    	}    	
    	array[t] += array[s];
    	array[s] = t;
    	return t;    	
    }
}
