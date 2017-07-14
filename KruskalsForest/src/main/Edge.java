package main;

public class Edge implements Comparable<Edge> {
	
	private Integer origin;
	private Integer destination;
	private double weight;
	private Edge next;
	
	
	
	public Edge(Integer origin, Integer destination, double weight, Edge next) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
		this.next = next;
	}



	public Edge(Integer origin, Integer destination, double weight) {
		this(origin, destination, weight, null);
	}



	/**
	 * @return the origin
	 */
	Integer getOrigin() {
		return origin;
	}



	/**
	 * @param origin the origin to set
	 */
	void setOrigin(Integer origin) {
		this.origin = origin;
	}



	/**
	 * @return the destination
	 */
	Integer getDestination() {
		return destination;
	}



	/**
	 * @param destination the destination to set
	 */
	void setDestination(Integer destination) {
		this.destination = destination;
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







	@Override
	public int compareTo(Edge other) {
		if (weight < other.getWeight()) {
			return -1;
		}
		if (weight > other.getWeight()) {
			return 1;
		}
		return 0;
	}
	
	public String toString() {
		return String.format("%4d%5d", origin, destination);
	}

	
	
	
	

	
	
	
	

}
