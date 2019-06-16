package org.coursera.algorithm.unionfind;

public interface UnionFind {
	int count();
	int root(int p);
	int canonical(int i);
	boolean connected(int p, int q);
	void union(int p, int q);
}
