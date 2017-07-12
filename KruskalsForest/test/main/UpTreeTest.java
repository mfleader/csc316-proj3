/**
 * 
 */
package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Matthew
 *
 */
public class UpTreeTest {
	
	private static final int[] keys = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	/**
	 * Test method for {@link main.UpTree#UpTree(int)}.
	 */
	@Test
	public void testUpTreeInt() {
		UpTree upTree = new UpTree(keys);		
		assertNotNull(upTree);
	}

	/**
	 * Test method for {@link main.UpTree#UpTree()}.
	 */
	@Test
	public void testUpTree() {
		UpTree upTree = new UpTree();
		assertNotNull(upTree);
	}

	/**
	 * Test method for {@link main.UpTree#makeSet(int)}.
	 */
	@Test
	public void testMakeSet() {
		UpTree upTree = new UpTree();
		try {
			upTree.makeSet(0);			
		} catch (IllegalArgumentException iae) {
			fail();
		}
	}

	/**
	 * Test method for {@link main.UpTree#find(main.UpTreeNode)}.
	 */
	@Test
	public void testFind() {
		UpTree upTree = new UpTree(keys);
		assertEquals(1, upTree.find(1).intValue());
		upTree.union(0, 1);
		assertEquals(0, upTree.find(1).intValue());
	}

	/**
	 * Test method for {@link main.UpTree#parent(main.UpTreeNode)}.
	 */
	@Test
	public void testParent() {
		UpTree upTree = new UpTree(keys);		
		for (int k = 0; k < keys.length; k++) {
			assertEquals(null, upTree.parent(k));
		}
	}

	/**
	 * Test method for {@link main.UpTree#union(main.UpTreeNode, main.UpTreeNode)}.
	 */
	@Test
	public void testUnion() {
		UpTree upTree = new UpTree(keys);
		assertEquals(0, upTree.union(0, 1).intValue());
		assertEquals(0, upTree.union(2, 0).intValue());
	}

}
