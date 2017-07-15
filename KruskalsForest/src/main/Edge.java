package main;

public class Edge implements Comparable<Edge> {
	
	private int origin;
	private int destination;
	private double weight;
	private Edge next;
	
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





	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		/*
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		*/
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
