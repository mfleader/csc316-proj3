/**
 * 
 */
package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Adjacency List class
 * @author Matthew F. Leader
 *
 */
public class AdjacencyListTest {
	

	private static final String ADJ_LIST = "   1    2"
											+ "\n   0    2"
											+ "\n   0    1";
	private static final String EDGE_LIST_AT_0 = "   1    2    3    4";

	/**
	 * Test method for {@link main.AdjacencyList#insertEdge(int, int, double)}.
	 */
	@Test
	public void testInsertEdge() {
		AdjacencyList list = new AdjacencyList();
		double weight = 1.0;
		
		list.insertEdge(0, 1, weight);
		list.insertEdge(0, 2, weight);
		list.insertEdge(1, 1, weight);
		list.insertEdge(1, 2, weight);
		list.insertEdge(1, 3, weight);
		list.insertEdge(2, 1, weight);
		assertEquals(6, list.numEdges());
		
	}

	/**
	 * Test method for {@link main.AdjacencyList#toString()}.
	 */
	@Test
	public void testToString() {
		AdjacencyList list = new AdjacencyList();
		double weight = 1.0;
		
		list.insertEdge(1, 2, weight);
		list.insertEdge(0, 1, weight);
		list.insertEdge(0, 2, weight);
		
		assertEquals(3, list.numEdges());
		assertEquals(ADJ_LIST, list.toString());
	}

	/**
	 * Test method for {@link main.AdjacencyList#edgeListAt(int)}.
	 */
	@Test
	public void testEdgeListAt() {
		AdjacencyList list = new AdjacencyList();
		double weight = 1.0;
		
		list.insertEdge(0, 3, weight);
		list.insertEdge(0, 1, weight);
		list.insertEdge(0, 2, weight);
		list.insertEdge(0, 4, weight);
		
		assertEquals(EDGE_LIST_AT_0, list.edgeListAt(0));
	}
	
	/**
	 * Test numVertices()
	 */
	@Test
	public void testNumVertices() {
		AdjacencyList list = new AdjacencyList();
		double weight = 1.0;
		
		list.insertEdge(0, 3, weight);
		list.insertEdge(0, 1, weight);
		list.insertEdge(0, 2, weight);
		list.insertEdge(0, 4, weight);
		
		assertEquals(5, list.numVertices());
	}

}
