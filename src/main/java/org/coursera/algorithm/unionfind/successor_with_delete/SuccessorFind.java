package org.coursera.algorithm.unionfind.successor_with_delete;

public class SuccessorFind
{
	int[] successors;
	int size;

	public SuccessorFind(int n)
	{
		successors = new int[n];
		size = n;
		for (int i = 0; i < n; i++)
		{
			successors[i] = i;
		}
	}

	void remove(int x)
	{
		successors[x] = successor(x + 1);
		--size;
	}

	public int successor(int x)
	{
		if (size == 0)
		{
			throw new IllegalStateException("No elems left");
		}
		if (x == successors[x]) return x;
		return successor(successors[x]);
	}
}
