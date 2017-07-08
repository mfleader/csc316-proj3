package main;


/**
 * This class represents a TreeNode position in a given tree, and has
 * functionality for a family tree.
 * @author Matthew F. Leader
 *
 * @param <Integer>
 * 			an element type for the TreeNode
 */
public class UpTreeNode {
	
    /** the data within the element */
	private int key;
	/** the parent TreeNode of this TreeNode */
	private UpTreeNode parent;
	/** if this node is the root, it's count equals the number of the nodes in the tree */
	private int count;


    /**
     * Constructs a Node given data and a pointer to the next element.
     * @param key
     *              the data in this element
     * @param next
     *              the pointer to the next element
     */
    public UpTreeNode(int key, UpTreeNode parent) {
        this.key = key;
        this.parent = parent;      
        setCount(0);
    }
    

    /**
     * Constructs an UpTreeNode with a null parent
     * @param key
     *              the data in this element
     */
    public UpTreeNode(Integer key) {
        this.key = key;
        parent = null;
        setCount(1);
    }      
    

    public int count() {
    	return count;
    }
    
    public void incrementCount() {
    	count++;
    }
    
    public void setCount(int newNodes) {
    	count = newNodes;
    }        
    
    public UpTreeNode getParent() {
    	return parent;
    }
    
    public void setParent(UpTreeNode n) {
    	this.parent = n;
    }
    
    public int key() {
    	return key;
    }
    
    public void setKey(int key) {
    	this.key = key;
    }
    

    
    



}
