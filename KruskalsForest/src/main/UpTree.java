package main;



/**
 * This UpTree class models the state and behavior of a union-find structure
 * that maintains disjoint sets
 * 
 * @author Matthew F. Leader
 *
 * @param <Integer>
 * 				the key data type
 */
public class UpTree {
	
	private Integer[] array;
	private static final int CAPACITY = 5000;
	
	public UpTree(int capacity) {
		array = new Integer[capacity];
	}
	
	public UpTree() {
		this(CAPACITY);
	}
	
	public UpTree(int[] array) {
		this.array = new Integer[CAPACITY];
		for (int k = 0; k < array.length; k++) {
			makeSet(array[k]);
		}
	}
	
    public void makeSet(int key) {
    	array[key] = new Integer(-1);
    }
    
    public Integer find(int key) {
    	while (parent(key) != null) {
    		key = parent(key);    		
    	}
    	return key;
    }
    
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
	
	/*
	private ArrayList<Integer> list;
	
	public UpTree(int[] array) {
		list = new ArrayList<Integer>();
		for (int k = 0; k < array.length; k++) {
			makeSet(array[k]);
		}
	}
	
	public UpTree() {
		list = new ArrayList<Integer>();
	}
	
	public void makeSet(int key) {
		list.set(key, new Integer(-1));
	}

    public Integer find(Integer index) {
    	while (list.get(index) > 0) {
    		index = parent(index);    		
    	}
    	return index;
    }
    
    public Integer parent(Integer childIndex) {
    	if (list.get(childIndex) > 0) {
    		return list.get(childIndex);	
    	}
    	return null;
    }
    
    public int get(int index) {
    	return list.get(index);
    }
    
    public int size() {
    	return size();
    }
    
    public Integer union(Integer s, Integer t) {
    	if (Math.abs(list.get(s)) >= Math.abs(list.get(t))) {
    		list.set(s, list.get(s) - list.get(t)); 
    		list.set(t, s);   		
    		return s;
    	}
    	list.set(t, list.get(t) - list.get(s));     	
    	list.set(s, t);
    	return t;    	
    }    
    */
    
    


    
    



    

}
