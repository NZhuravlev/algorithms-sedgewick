package org.coursera.algorithm.unionfind.successor_with_delete;

import org.coursera.algorithm.unionfind.WeightedQuickUnion;

public class WeightedSuccessorFind implements SuccessorFind
{
	private WeightedQuickUnion uf;

	public WeightedSuccessorFind(int n)
	{
		uf = new WeightedQuickUnion(n);
	}

	@Override
	public void remove(int x)
	{
		uf.union(x, x + 1);
	}

	@Override
	public int successor(int x)
	{
		return uf.canonical(x);
	}
}
