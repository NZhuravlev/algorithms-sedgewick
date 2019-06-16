package org.coursera.algorithm;

public class Utils
{
	public static void assertEquals(long actual, long expected) {
		if (expected != actual)
			throw new IllegalStateException(
				String.format("\nExpected:\t%s\nActual:\t\t%s", expected, actual));
	}

}
