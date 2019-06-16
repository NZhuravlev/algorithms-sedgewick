package org.coursera.algorithm.unionfind.canonicalelement;

import org.coursera.algorithm.unionfind.WeightedQuickUnion;

import static org.coursera.algorithm.Utils.assertEquals;

public class CanonicalElement
{
	public static void main(String[] args)
	{
		var uf = new WeightedQuickUnion(10);
		uf.union(0,1);
		uf.union(2,3);
		uf.union(4,5);
		uf.union(6,7);
		uf.union(8,9);
		uf.union(0,4); // 5
		assertEquals(uf.canonical(1), 5);
		uf.union(1,6);
		assertEquals(uf.canonical(1), 7);
		assertEquals(uf.canonical(2), 3);
		assertEquals(uf.canonical(3), 3);
		assertEquals(uf.canonical(4), 7);
		assertEquals(uf.canonical(5), 7);
		assertEquals(uf.canonical(6), 7);
		assertEquals(uf.canonical(7), 7);
		assertEquals(uf.canonical(8), 9);
		assertEquals(uf.canonical(9), 9);
	}
}
