package by.crousera.algorithms.week.first;

/*
 * Simple inversion counter -  Time Complexity: O(n^2)
 */

public class SimpleInversionCounter {

	public static long countInversions(int[] array) {
		long counter = 0; // need long here cause int isn't enough for 100 000 array
 		int arrayLength = array.length;
		int lastElementIndex = arrayLength - 1;

		for (int i = 0; i < lastElementIndex; i++) {
			for (int j = i + 1; j <= lastElementIndex; j++) {
				if (array[i] > array[j]) {
					counter++;
				}
			}
		}

		return counter;
	}
}
