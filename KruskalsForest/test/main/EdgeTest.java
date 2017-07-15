package main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EdgeTest {
	
	private final static Integer ORIGIN = 0;
	private final static Integer DESTINATION = 1;
	private final static double WEIGHT = 1.0;
	private final static ArrayList<Edge> MIN_SPAN_LIST = new ArrayList<Edge>();
	

	@Test
	public void testCompareTo() {
		Edge edge0 = new Edge(6, 7, 3.0);
		Edge edge1 = new Edge(6, 7, 4.0);
		Edge edge2 = new Edge(6, 7, 5.0);
		
		assertEquals(0, edge1.compareTo(edge1));
		
		//return 1 when this edge is greater than the other edge
		assertEquals(1, edge1.compareTo(edge0));
		//return -1 when this edge is less than the other edge
		assertEquals(-1, edge1.compareTo(edge2));
	}

	@Test
	public void testToString() {
		Edge edge = new Edge(ORIGIN, DESTINATION, WEIGHT);
		assertEquals("   0    1", edge.toString());
	}
	
	@Test
	public void testEquals() {
		Edge edge0 = new Edge(6, 7, 3.0);
		Edge edge1 = new Edge(7, 6, 3.0);
		
		assertTrue(edge0.equals(edge1));
		assertTrue(edge1.equals(edge0));
		assertTrue(edge0.equals(edge0));
	}
	
	@Test
	public void testCompareVerticesTo() {
		Edge edge0 = new Edge(3, 6, 3.0);
		Edge edge1 = new Edge(3, 7, 3.0);
		Edge edge2 = new Edge(4, 8, 3.0);
		Edge edge3 = new Edge(2, 6, 3.0);
		Edge edge4 = new Edge(3, 5, 3.0);
		
		assertEquals(-1, edge0.compareVerticesTo(edge1));
		assertEquals(-1, edge0.compareVerticesTo(edge2));		
		assertEquals(1, edge0.compareVerticesTo(edge3));
		assertEquals(1, edge0.compareVerticesTo(edge4));
	}
	
	@Test
	public void testListByVertices() {
		
		Edge edge0 = new Edge(3, 9, 3.0);
		Edge edge1 = new Edge(9, 15, 3.0);
		Edge edge2 = new Edge(2, 8, 3.0);
		Edge edge3 = new Edge(8, 14, 3.0);
		Edge edge4 = new Edge(0, 6, 3.0);
		MIN_SPAN_LIST.add(findInsertion(edge0), edge0);
		MIN_SPAN_LIST.add(findInsertion(edge1), edge1);
		MIN_SPAN_LIST.add(findInsertion(edge2), edge2);
		MIN_SPAN_LIST.add(findInsertion(edge3), edge3);
		MIN_SPAN_LIST.add(findInsertion(edge4), edge4);
		
		System.out.println(MIN_SPAN_LIST.toString());
	}
	
	private int findInsertion(Edge edge) {
		if (!MIN_SPAN_LIST.isEmpty()) {
			for (int k = 0; k < MIN_SPAN_LIST.size(); k++) {
				Edge other = (Edge) MIN_SPAN_LIST.get(k); 
				if (edge.compareVerticesTo(other) < 0) {
					return k;
				}
			}
			return MIN_SPAN_LIST.size();
		}
		return 0;
	}

}
