package by.crousera.algorithms.week.first;

/*
 * Simple inversion counter -  Time Complexity: O(n^2)
 */

public class SimpleInversionCounter {

	public long countInversions(int[] array) {
		long counter = 0;
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
