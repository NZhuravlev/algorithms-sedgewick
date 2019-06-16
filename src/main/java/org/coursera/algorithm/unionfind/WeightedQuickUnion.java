package org.coursera.algorithm.unionfind;

public class WeightedQuickUnion implements UnionFind {
	private int[] connections;   // connections[i] = connections of i
	private int[] size;     // size[i] = number of sites in subtree rooted at i
	private int[] max;
	private int count;      // number of components

	/**
	 * Initializes an empty union–root data structure with {@code n} sites
	 * {@code 0} through {@code n-1}. Each site is initially in its own
	 * component.
	 *
	 * @param  n the number of sites
	 * @throws IllegalArgumentException if {@code n < 0}
	 */
	public WeightedQuickUnion(int n) {
		count = n;
		connections = new int[n];
		size = new int[n];
		max = new int[n];
		for (int i = 0; i < n; i++) {
			connections[i] = i;
			max[i] = i;
			size[i] = 1;
		}
	}

	/**
	 * Returns the number of components.
	 *
	 * @return the number of components (between {@code 1} and {@code n})
	 */
	@Override
	public int count() {
		return count;
	}

	/**
	 * Returns the component identifier for the component containing site {@code p}.
	 *
	 * @param  p the integer representing one object
	 * @return the component identifier for the component containing site {@code p}
	 * @throws IllegalArgumentException unless {@code 0 <= p < n}
	 */
	@Override
	public int root(int p) {
		validate(p);
		while (p != connections[p])
			p = connections[p];
		return p;
	}

	@Override
	public int find(int i)
	{
		validate(i);
		return max[root(i)];
	}

	/**
	 * Returns true if the the two sites are in the same component.
	 *
	 * @param  p the integer representing one site
	 * @param  q the integer representing the other site
	 * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException unless
	 *         both {@code 0 <= p < n} and {@code 0 <= q < n}
	 */
	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	/**
	 * Merges the component containing site {@code p} with the
	 * the component containing site {@code q}.
	 *
	 * @param  p the integer representing one site
	 * @param  q the integer representing the other site
	 * @throws IllegalArgumentException unless
	 *         both {@code 0 <= p < n} and {@code 0 <= q < n}
	 */
	@Override
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if (rootP == rootQ) return;
		int maxP = max[rootP];
		int maxQ = max[rootQ];
		// make smaller root point to larger one
		if (size[rootP] < size[rootQ]) {
			connections[rootP] = rootQ;
			size[rootQ] += size[rootP];
			max[rootQ] = Math.max(maxP, maxQ);
		}
		else {
			connections[rootQ] = rootP;
			size[rootP] += size[rootQ];
			max[rootP] = Math.max(maxP, maxQ);
		}
		count--;
	}

	// validate that p is a valid index
	private void validate(int p) {
		int n = connections.length;
		if (p < 0 || p >= n) {
			throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
		}
	}
}
