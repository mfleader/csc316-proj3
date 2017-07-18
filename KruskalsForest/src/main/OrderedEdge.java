/**
 * 
 */
package main;

/**
 * This class represents an Edge where the vertices are ordered so that the origin
 * vertex is always less than or equal to the destination vertex.
 * @author Matthew F Leader
 *
 */
public class OrderedEdge extends Edge {
	
	/**
	 * Constructs an OrderedEdge that represents a connection between two vertices,
	 * and a weight of priority/importance/value associated with this Edge.
	 * @param origin
	 * 						the first vertex in the pair
	 * @param destination
	 * 						the second vertex in the pair
	 * @param weight
	 * 						the value associated with this edge
	 * @param next
	 * 						the next Edge in the list of Edges
	 */
	public OrderedEdge(int origin, int destination, double weight, Edge next) {	
		super((origin < destination) ? origin : destination,
			  (origin < destination) ? destination : origin,
			   weight, next);
	}


	public OrderedEdge(int origin, int destination, double weight) {
		this(origin, destination, weight, null);
	}

}
