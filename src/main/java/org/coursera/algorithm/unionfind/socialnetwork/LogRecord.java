package org.coursera.algorithm.unionfind.socialnetwork;

public class LogRecord
{
	private long timestamp;
	private int left;
	private int right;

	public LogRecord(long timestamp, int left, int right)
	{
		this.timestamp = timestamp;
		this.left = left;
		this.right = right;
	}

	public long getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(long timestamp)
	{
		this.timestamp = timestamp;
	}

	public int getLeft()
	{
		return left;
	}

	public void setLeft(int left)
	{
		this.left = left;
	}

	public int getRight()
	{
		return right;
	}

	public void setRight(int right)
	{
		this.right = right;
	}
}
