/**
 * 
 */
package main;

/**
 * @author Matthew F Leader
 *
 */
public class OrderedEdge extends Edge {
	
	public OrderedEdge(int origin, int destination, double weight, Edge next) {	
		super((origin < destination) ? origin : destination,
			  (origin < destination) ? destination : origin,
			   weight, next);
	}


	public OrderedEdge(int origin, int destination, double weight) {
		this(origin, destination, weight, null);
	}

}
