package org.coursera.algorithm.unionfind.successor_with_delete;

import static org.coursera.algorithm.Utils.assertEquals;

public class SuccessorWithDelete
{
	public static void main(String[] args)
	{
		var sf = new SuccessorFind(10);
		sf.remove(0);
		assertEquals(sf.successor(0), 1);
		sf.remove(1);
		assertEquals(sf.successor(0), 2);
		sf.remove(4);
		assertEquals(sf.successor(0), 2);
		assertEquals(sf.successor(3), 3);
		assertEquals(sf.successor(4), 5);
		sf.remove(3);
		assertEquals(sf.successor(0), 2);
		assertEquals(sf.successor(3), 5);
		assertEquals(sf.successor(4), 5);
		sf.remove(2);
		assertEquals(sf.successor(0), 5);
		assertEquals(sf.successor(3), 5);
		assertEquals(sf.successor(4), 5);
	}
}
