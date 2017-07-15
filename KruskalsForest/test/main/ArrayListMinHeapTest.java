/**
 * 
 */
package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Matthew F. Leader
 *
 */
public class ArrayListMinHeapTest {
	
	private static final Integer[] testHeap1 = { 1, 2, 3, 4 };
	private static final Integer[] testHeap3 = { 1, 3, 2, 5, 4, 5 };
	private static final double WEIGHT_5 = 5.0;
	private static final double WEIGHT_3 = 3.0;
	private static final double WEIGHT_4 = 4.0;
	private static final double WEIGHT_6 = 6.0;
	private static final Edge EDGE_0 = new Edge(0, 1, WEIGHT_5);
	//private static final Edge EDGE_ = new Edge(, , WEIGHT_5);
	
	private static final Edge[] EDGE_IN = { new Edge(0, 1, WEIGHT_5),
											  new Edge(1, 2, WEIGHT_5),
											  new Edge(2, 3, WEIGHT_5),
											  new Edge(3, 4, WEIGHT_5),
											  new Edge(4, 5, WEIGHT_5),
											  new Edge(12, 13, WEIGHT_5),
											  new Edge(13, 14, WEIGHT_5),
											  new Edge(14, 15, WEIGHT_5),
											  new Edge(15, 16, WEIGHT_5),
											  new Edge(16, 17, WEIGHT_5),
											  new Edge(6, 7, WEIGHT_3),
											  new Edge(7, 8, WEIGHT_3),
											  new Edge(8, 9, WEIGHT_3),
											  new Edge(9, 10, WEIGHT_3),
											  new Edge(10, 11, WEIGHT_3),
											  new Edge(0, 6, WEIGHT_4),
											  new Edge(12, 6, WEIGHT_4),
											  new Edge(1, 6, WEIGHT_6),
											  new Edge(13, 6, WEIGHT_6),
											  new Edge(1, 7, WEIGHT_4),
											  new Edge(13, 7, WEIGHT_4),
											  new Edge(14, 7, WEIGHT_6),
											  new Edge(2, 7, WEIGHT_6),
											  new Edge(14, 8, WEIGHT_4),
											  new Edge(2, 8, WEIGHT_4),
											  new Edge(15, 8, WEIGHT_6),
											  new Edge(3, 8, WEIGHT_6),
											  new Edge(15, 9, WEIGHT_4),
											  new Edge(16, 9, WEIGHT_6),
											  new Edge(3, 9, WEIGHT_4),
											  new Edge(4, 9, WEIGHT_6),
											  new Edge(16, 10, WEIGHT_4),
											  new Edge(17, 10, WEIGHT_6),
											  new Edge(4, 10, WEIGHT_4),
											  new Edge(5, 10, WEIGHT_6),
											  new Edge(5, 11, WEIGHT_4),
											  new Edge(17, 11, WEIGHT_4)};
	private static final Edge[] EDGE_OUT = { new Edge(6, 7, WEIGHT_3),
			  								 new Edge(0, 6, WEIGHT_4),
			  								 new Edge(7, 8, WEIGHT_3),
			  								 new Edge(6, 12, WEIGHT_4),
			  								 new Edge(1, 7, WEIGHT_4),
			  								 new Edge(8, 9, WEIGHT_3),
			  								 new Edge(9, 10, WEIGHT_3),
			  								 new Edge(10, 16, WEIGHT_4),
			  								 new Edge(5, 11, WEIGHT_4),
			  								 new Edge(7, 13, WEIGHT_4),
			  								 new Edge(4, 5, WEIGHT_5),
			  								 new Edge(8, 14, WEIGHT_4),
			  								 new Edge(2, 3, WEIGHT_5),
			  								 new Edge(9, 15, WEIGHT_4),
			  								 new Edge(10, 11, WEIGHT_3),
			  								 new Edge(0, 1, WEIGHT_4),
			  								 new Edge(4, 10, WEIGHT_4),
			  								 new Edge(11, 17, WEIGHT_4),
			  								 new Edge(6, 13, WEIGHT_6),
			  								 new Edge(16, 17, WEIGHT_5),
			  								 new Edge(1, 2, WEIGHT_5),
			  								 new Edge(7, 14, WEIGHT_6),
			  								 new Edge(2, 7, WEIGHT_6),
			  								 new Edge(12, 13, WEIGHT_5),
			  								 new Edge(2, 8, WEIGHT_4),
			  								 new Edge(8, 15, WEIGHT_6),
			  								 new Edge(3, 8, WEIGHT_6),
			  								 new Edge(13, 14, WEIGHT_5),
			  								 new Edge(9, 16, WEIGHT_6),
			  								 new Edge(3, 9, WEIGHT_4),
			  								 new Edge(4, 9, WEIGHT_6),
			  								 new Edge(14, 15, WEIGHT_5),
			  								 new Edge(10, 17, WEIGHT_6),
			  								 new Edge(3, 4, WEIGHT_5),
			  								 new Edge(5, 10, WEIGHT_6),
			  								 new Edge(1, 6, WEIGHT_6),
			  								 new Edge(15, 16, WEIGHT_5)};
													

	/**
	 * Test method for {@link main.ArrayListMinHeap#ArrayListMinHeap()}.
	 */
	@Test
	public void testArrayListMinHeap() {
		ArrayListMinHeap<Integer>  heap = new ArrayListMinHeap<Integer>();
		assertTrue(heap.isEmpty());
		heap.insert(1);
		assertFalse(heap.isEmpty());
		assertEquals(1, heap.removeMin().intValue());
	}

	/**
	 * Test method for {@link main.ArrayListMinHeap#ArrayListMinHeap(int[])}.
	 */
	@Test
	public void testArrayListMinHeapIntArray() {
		ArrayListMinHeap<Integer>  heap = new ArrayListMinHeap<Integer>(testHeap1);
		assertFalse(heap.isEmpty());
		assertEquals(4, heap.size());
	}

	/**
	 * Test method for {@link main.ArrayListMinHeap#insert(int)}.
	 */
	@Test
	public void testInsert() {
		ArrayListMinHeap<Integer>  heap = new ArrayListMinHeap<Integer>();
		heap.insert(2);
		heap.insert(2);
		heap.insert(2);
		heap.insert(1);
		assertEquals(4, heap.size());
		
		//Validate heap passes when heap property is not broken
		try {
			assertTrue(heap.isHeap());
		} catch (IllegalStateException ise) {
			fail();
		}		
	}

	/**
	 * Test method for {@link main.ArrayListMinHeap#removeMin()}.
	 */
	@Test
	public void testRemoveMin() {
		ArrayListMinHeap<Integer>  heap = new ArrayListMinHeap<Integer>(testHeap1);
		assertFalse(heap.isEmpty());
		assertEquals(4, heap.size());
		
		try {
			assertEquals(1, heap.removeMin().intValue());
			assertEquals(3, heap.size());
		} catch (IllegalStateException ise) {
			fail();
		}
		
		try {
			assertEquals(2, heap.removeMin().intValue());
			assertEquals(2, heap.size());
		} catch (IllegalStateException ise) {
			fail();
		}
		
		try {
			assertEquals(3, heap.removeMin().intValue());
			assertEquals(1, heap.size());
		} catch (IllegalStateException ise) {
			fail();
		}
		
		try {
			assertEquals(4, heap.removeMin().intValue());
			assertEquals(0, heap.size());
		} catch (IllegalStateException ise) {
			fail();
		}
		
		try {
			heap.insert(2);
			assertEquals(1, heap.size());
			assertEquals(2, heap.removeMin().intValue());
			assertTrue(heap.isEmpty());
		} catch (IllegalStateException ise) {
			fail();
		}		
	}
	
	
	@Test
	public void testRemoveMinEdge() {
		ArrayListMinHeap<Edge> edgeHeap = new ArrayListMinHeap<Edge>();
		try {
			for (int k = 0; k < EDGE_IN.length; k++) {
				edgeHeap.insert(EDGE_IN[k]);
			}
			
			System.out.println("=0==============================");
			System.out.println(edgeHeap.toString());
			System.out.println("=1==============================");
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[0]));			
			System.out.println(edgeHeap.toString());
			System.out.println("=2==============================");
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[1]));			
			System.out.println(edgeHeap.toString());
			
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[2]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[3]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[4]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[5]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[6]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[7]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[8]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[9]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[10]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[11]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[12]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[13]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[14]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[15]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[16]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[17]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[18]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[19]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[20]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[21]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[22]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[23]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[24]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[25]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[26]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[27]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[28]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[29]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[30]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[31]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[32]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[33]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[34]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[35]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[36]));
			assertTrue(edgeHeap.removeMin().equals(EDGE_OUT[37]));
		
		} catch (NullPointerException | IllegalStateException ex) {
			fail();
		}
	}

	/**
	 * Test method for {@link main.ArrayListMinHeap#minChildIndex(int)}.
	 */
	@Test
	public void testMinChildIndex() {
		ArrayListMinHeap<Integer>  heap = new ArrayListMinHeap<Integer>(testHeap3);
		
		assertEquals(-1, heap.minChildIndex(heap.size()));
		assertEquals(5, heap.minChildIndex(2));
		assertEquals(4, heap.minChildIndex(1));
		assertEquals(2, heap.minChildIndex(0));		
	}
	
	/**
	 * Test method for isHeap()
	 */
	@Test
	public void testIsHeap() {
		ArrayListMinHeap<Integer>  heap = new ArrayListMinHeap<Integer>(testHeap1);
		assertFalse(heap.isEmpty());
		assertEquals(4, heap.size());
		
		//Validate heap passes when heap property is not broken
		try {
			assertTrue(heap.isHeap());
		} catch (IllegalStateException ise) {
			fail();
		}
	}
	
	/**
	 * Test method for toString()
	 */
	@Test
	public void testToString() {
		ArrayListMinHeap<Integer>  heap2 = new ArrayListMinHeap<Integer>(testHeap1);
		assertEquals(testHeap1[0]
					 + "\n" + testHeap1[1]
					 + "\n" + testHeap1[2]
					 + "\n" + testHeap1[3], heap2.toString());
		
		
		
	}
	
	@Test
	public void testToStringEdge() {
		ArrayListMinHeap<Edge> heap = new ArrayListMinHeap<Edge>();
		try {
			for (int k = 0; k < EDGE_IN.length; k++) {
				heap.insert(EDGE_IN[k]);
			}		
		} catch (NullPointerException | IllegalStateException ex) {
			fail();
		}
		
	}
}
