package main;

public class Vertex<K> {
	
	private K key;
	
	
	public Vertex(K key) {
		this.key = key;
	}


	/**
	 * @return the key
	 */
	K getKey() {
		return key;
	}


	/**
	 * @param key the key to set
	 */
	void setKey(K key) {
		this.key = key;
	}
	
	

}
