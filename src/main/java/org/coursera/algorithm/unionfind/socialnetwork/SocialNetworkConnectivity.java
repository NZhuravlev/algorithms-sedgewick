package org.coursera.algorithm.unionfind.socialnetwork;

import org.coursera.algorithm.unionfind.WeightedQuickUnion;
import java.util.Collection;
import java.util.List;

import static org.coursera.algorithm.Utils.assertEquals;

public class SocialNetworkConnectivity
{

	private static long connectedOn(Collection<LogRecord> log, int n)
	{
		if (log.isEmpty()) return 0;
		var uf = new WeightedQuickUnion(n);
		var logIter = log.iterator();
		LogRecord rec = null;
		while (uf.count() > 1 && logIter.hasNext() && (rec = logIter.next()) != null) {
			uf.union(rec.getLeft(), rec.getRight());
		}
		return rec == null ? 0 : rec.getTimestamp();
	}

	public static void main(String[] args)
	{
		assertEquals(
			connectedOn(List.of(
				new LogRecord(0, 0, 1),
				new LogRecord(1, 2, 1),
				new LogRecord(2, 4, 6),
				new LogRecord(3, 4, 3),
				new LogRecord(4, 5, 6),
				new LogRecord(5, 4, 7),
				new LogRecord(6, 5, 7),
				new LogRecord(7, 3, 2),
				new LogRecord(8, 6, 1),
				new LogRecord(9, 0, 7)
			), 8),
			7
		);
		assertEquals(
			connectedOn(List.of(
				new LogRecord(0, 0, 1),
				new LogRecord(1, 2, 3),
				new LogRecord(2, 4, 5),
				new LogRecord(3, 6, 7),
				new LogRecord(4, 0, 2),
				new LogRecord(5, 0, 4),
				new LogRecord(6, 0, 6),
				new LogRecord(7, 3, 7),
				new LogRecord(8, 6, 1),
				new LogRecord(9, 0, 7)
			), 8),
			6
		);
	}

}
