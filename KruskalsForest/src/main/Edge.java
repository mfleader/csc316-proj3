package main;

public class Edge {
	
	private Vertex<Integer> vertex1;
	private Vertex<Integer> vertex2;
	private int weight;
	private Edge next;
	
	public Edge(Vertex<Integer> vertex1, Vertex<Integer> vertex2, int weight, Edge next) {
		//super();
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
		this.next = next;
	}
	
	public Edge(Vertex<Integer> vertex1, Vertex<Integer> vertex2, int weight) {
		this(vertex1, vertex2, weight, null);
	}

	/**
	 * @return the vertex1
	 */
	Vertex<Integer> getVertex1() {
		return vertex1;
	}

	/**
	 * @param vertex1 the vertex1 to set
	 */
	void setVertex1(Vertex<Integer> vertex1) {
		this.vertex1 = vertex1;
	}

	/**
	 * @return the vertex2
	 */
	Vertex<Integer> getVertex2() {
		return vertex2;
	}

	/**
	 * @param vertex2 the vertex2 to set
	 */
	void setVertex2(Vertex<Integer> vertex2) {
		this.vertex2 = vertex2;
	}

	/**
	 * @return the weight
	 */
	int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the next
	 */
	Edge getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	void setNext(Edge next) {
		this.next = next;
	}
	
	
	
	

}
