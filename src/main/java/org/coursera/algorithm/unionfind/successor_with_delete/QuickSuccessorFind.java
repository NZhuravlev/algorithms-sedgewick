package org.coursera.algorithm.unionfind.successor_with_delete;

public class QuickSuccessorFind implements SuccessorFind
{
	private int[] successors;
	private int size;

	public QuickSuccessorFind(int n)
	{
		successors = new int[n];
		size = n;
		for (int i = 0; i < n; i++)
		{
			successors[i] = i;
		}
	}

	@Override
	public void remove(int x)
	{
		if (x == successors.length -1)
			throw new IllegalArgumentException("Can't remove right edge element");
		if (x != successors[x]) return;
		successors[x] = successor(x + 1);
		--size;
	}

	@Override
	public int successor(int x)
	{
		if (size == 0)
		{
			throw new IllegalStateException("No elems left");
		}
		int el = x;
		int c = 1;
		while (x != successors[x])
		{
			successors[x] = successors[successors[x]];
			x = successors[x];
			c++;
		}
		System.out.println(String.format("Successor %s complexity is %s", el, c));
		return x;
	}
}
