package main;

public class Edge implements Comparable<Edge> {
	
	/** the first vertex in this vertex pair */
	private int origin;
	/** the second vertex in this vertex pair */
	private int destination;
	/** the value associated with this vertex pair */
	private double weight;
	/** the next Edge in the list of Edges */
	private Edge next;
	
	/**
	 * Constructs an Edge that represents a connection between two vertices,
	 * and a weight of priority/importance/value associated with this edge.
	 * @param origin
	 * 						the first vertex in the pair
	 * @param destination
	 * 						the second vertex in the pair
	 * @param weight
	 * 						the value associated with this edge
	 * @param next
	 * 						the next Edge in the list of Edges
	 */
	public Edge(int origin, int destination, double weight, Edge next) {		
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
		this.next = next;
	}
	
	public Edge(int origin, int destination, double weight) {
		this(origin, destination, weight, null);
	}



	/**
	 * @return the origin
	 */
	int getOrigin() {
		return origin;
	}



	/**
	 * @param origin the origin to set
	 */
	void setOrigin(int origin) {
		this.origin = origin;
	}



	/**
	 * @return the destination
	 */
	int getDestination() {
		return destination;
	}



	/**
	 * @param destination the destination to set
	 */
	void setDestination(int destination) {
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
	
	public int compareVerticesTo(Edge other) {
		if (this.origin < other.getOrigin()) {
			return -1;
		} else if (this.origin == other.getOrigin()) {
			if (this.destination < other.getDestination()) {
				return -1;
			} else if (this.destination == other.getDestination()) {
				return 0;
			}
		}		
		return 1;
	}
	
	
	public String toString() {
		return String.format("%4d %4d", origin, destination);
	}


	@Override
	public boolean equals(Object obj) {
		Edge other = (Edge) obj;
		if (destination != other.getDestination() && destination != other.getOrigin()) {
			return false;
		}
		if (origin != other.getOrigin() && origin != other.getDestination()) {
			return false;
		}		
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	
	
	
	
	

	
	
	
	

}
