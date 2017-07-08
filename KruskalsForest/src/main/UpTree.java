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
	
	

	private int[] array;
	private static final int CAPACITY = 5000;
	
	public UpTree(int capacity) {
		array = new int[capacity];
	}
	
	public UpTree() {
		this(CAPACITY);
	}
	
    public UpTreeNode makeSet(int key) {
    	array[key] = -1;
    	return new UpTreeNode(key);
    }
    


    public UpTreeNode find(UpTreeNode node) {
    	while (parent(node) != null) {
    		node = parent(node);    		
    	}
    	return node;
    }
    
    public UpTreeNode parent(UpTreeNode child) {
    	return child.getParent();
    }
    
    
    /**
     * Merges the clusters containing root nodes s and t
     * @param s
     * 				the root of a set
     * @param t
     * 				the root of a set
     */
    public UpTreeNode union(UpTreeNode s, UpTreeNode t) {
    	if (Math.abs(array[s.key()]) >= Math.abs(array[t.key()])) {
    		array[s.key()] -= array[t.key()]; 
    		array[t.key()] = s.key();    		
    		return s;
    	}    	
    	array[t.key()] -= array[s.key()];
    	array[s.key()] = t.key();
    	return t;    	
    }
    
    

}
