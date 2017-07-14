package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class EdgeTest {
	
	private final static Integer ORIGIN = 0;
	private final static Integer DESTINATION = 1;
	private final static double WEIGHT = 1.0;
	

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		Edge edge = new Edge(ORIGIN, DESTINATION, WEIGHT);
		assertEquals("   0    1", edge.toString());
	}

}
