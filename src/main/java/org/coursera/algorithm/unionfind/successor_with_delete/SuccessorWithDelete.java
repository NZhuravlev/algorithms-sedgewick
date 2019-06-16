package org.coursera.algorithm.unionfind.successor_with_delete;

import static org.coursera.algorithm.Utils.assertEquals;

public class SuccessorWithDelete
{
	private static void test(SuccessorFind sf)
	{
		sf.remove(6);
		sf.remove(0);
		assertEquals(sf.successor(0), 1);
		sf.remove(1);
		assertEquals(sf.successor(0), 2);
		sf.remove(4);
		assertEquals(sf.successor(0), 2);
		assertEquals(sf.successor(1), 2);
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

	private static void testEdge(SuccessorFind sf)
	{
		sf.remove(1);
		sf.remove(2);
		sf.remove(3);
		sf.remove(4);
		sf.remove(5);
		sf.remove(6);
		sf.remove(7);
		sf.remove(8);
		sf.remove(9);
		sf.remove(10);
		sf.remove(11);
		sf.remove(12);
		sf.remove(13);
		sf.remove(14);
		sf.remove(15);
		sf.remove(16);
		sf.remove(17);
		sf.remove(18);
		sf.remove(0);
	}

	public static void main(String[] args)
	{
		test(new WeightedSuccessorFind(10));
		testEdge(new WeightedSuccessorFind(20));
	}
}
