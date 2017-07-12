package main;

public class Edge {
	
	private Integer vertex1;
	private Integer vertex2;
	private double weight;
	private Edge next;
	
	public Edge(Integer vertex1, Integer vertex2, double weight, Edge next) {
		//super();
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
		this.next = next;
	}
	
	public Edge(Integer vertex1, Integer vertex2, double weight) {
		this(vertex1, vertex2, weight, null);
	}

	/**
	 * @return the vertex1
	 */
	Integer getVertex1() {
		return vertex1;
	}

	/**
	 * @param vertex1 the vertex1 to set
	 */
	void setVertex1(Integer vertex1) {
		this.vertex1 = vertex1;
	}

	/**
	 * @return the vertex2
	 */
	Integer getVertex2() {
		return vertex2;
	}

	/**
	 * @param vertex2 the vertex2 to set
	 */
	void setVertex2(Integer vertex2) {
		this.vertex2 = vertex2;
	}

	/**
	 * @return the weight
	 */
	double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	void setWeight(double weight) {
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
