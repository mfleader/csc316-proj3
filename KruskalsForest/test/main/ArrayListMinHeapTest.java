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
	
	private static final int[] testHeap1 = { 1, 2, 3, 4 };
	private static final int[] testHeap2 = { 2, 2, 2, 1 };
	private static final int[] testHeap3 = { 1, 3, 2, 5, 4, 5 };

	/**
	 * Test method for {@link main.ArrayListMinHeap#ArrayListMinHeap()}.
	 */
	@Test
	public void testArrayListMinHeap() {
		ArrayListMinHeap  heap = new ArrayListMinHeap();
		assertTrue(heap.isEmpty());
		heap.insert(1);
		assertFalse(heap.isEmpty());
		assertEquals(1, heap.removeMin());
	}

	/**
	 * Test method for {@link main.ArrayListMinHeap#ArrayListMinHeap(int[])}.
	 */
	@Test
	public void testArrayListMinHeapIntArray() {
		ArrayListMinHeap  heap = new ArrayListMinHeap(testHeap1);
		assertFalse(heap.isEmpty());
		assertEquals(4, heap.size());
	}




	/**
	 * Test method for {@link main.ArrayListMinHeap#insert(int)}.
	 */
	@Test
	public void testInsert() {
		ArrayListMinHeap heap = new ArrayListMinHeap();
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
		ArrayListMinHeap  heap = new ArrayListMinHeap(testHeap1);
		assertFalse(heap.isEmpty());
		assertEquals(4, heap.size());
		
		try {
			assertEquals(1, heap.removeMin());
			assertEquals(3, heap.size());
		} catch (IllegalStateException ise) {
			fail();
		}
		
		try {
			assertEquals(2, heap.removeMin());
			assertEquals(2, heap.size());
		} catch (IllegalStateException ise) {
			fail();
		}
		
		try {
			assertEquals(3, heap.removeMin());
			assertEquals(1, heap.size());
		} catch (IllegalStateException ise) {
			fail();
		}
		
		try {
			assertEquals(4, heap.removeMin());
			assertEquals(0, heap.size());
		} catch (IllegalStateException ise) {
			fail();
		}
		
		try {
			heap.insert(2);
			assertEquals(1, heap.size());
			assertEquals(2, heap.removeMin());
			assertTrue(heap.isEmpty());
		} catch (IllegalStateException ise) {
			fail();
		}
		
	}

	/**
	 * Test method for {@link main.ArrayListMinHeap#minChildIndex(int)}.
	 */
	@Test
	public void testMinChildIndex() {
		ArrayListMinHeap  heap = new ArrayListMinHeap(testHeap3);
		
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
		ArrayListMinHeap  heap = new ArrayListMinHeap(testHeap1);
		assertFalse(heap.isEmpty());
		assertEquals(4, heap.size());
		
		//Validate heap passes when heap property is not broken
		try {
			assertTrue(heap.isHeap());
		} catch (IllegalStateException ise) {
			fail();
		}
		


	}

}
