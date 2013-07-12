package by.crousera.algorithms.week.first;

/*
 *  The example was taken from http://cgi.csc.liv.ac.uk/~martin/teaching/comp202/Java/Inversions-code.html
 *  Smart inversion counter -  Time Complexity: O(n*log(n))
 */
public class SmartInversionCounter {

	public static long countInversions(int nums[]) {
		int mid = nums.length / 2;
		int k;
		long countLeft, countRight, countMerge; // need long here cause int isn't enough for 100 000 array
 
		/* If the list is small, there's nothing to do. */
		if (nums.length <= 1) {
			return 0;
		}

		/*
		 * Otherwise, we create new arrays and split the original array into two parts
		 */
		int left[] = new int[mid];
		int right[] = new int[nums.length - mid];

		for (k = 0; k < mid; k++)
			left[k] = nums[k];
		for (k = 0; k < nums.length - mid; k++)
			right[k] = nums[mid + k];

		/*
		 * Recursively count the inversions in each part.
		 */
		countLeft = countInversions(left);
		countRight = countInversions(right);

		/*
		 * Now merge the two sublists together, and count the inversions caused
		 * by pairs of elements, one from each half of the original list.
		 */
		int result[] = new int[nums.length];
		countMerge = mergeAndCount(left, right, result);

		/*
		 * Finally, put the resulting list back into the original one. This is
		 * necessary for the recursive calls to work correctly.
		 */
		for (k = 0; k < nums.length; k++){
			nums[k] = result[k];
		}

		return countLeft + countRight + countMerge;
	} 

	/*
	 * This function will merge the two arrays, and count the number of
	 * inversions caused by the elements in the "right" array that are less than
	 * elements in the "left" array.
	 */
	private static int mergeAndCount(int left[], int right[], int result[]) {
		int a = 0; 
		int b = 0; 
		int k = 0;
		int count = 0; 

		while ((a < left.length) && (b < right.length)) {
			if (left[a] <= right[b]) {
				result[k] = left[a++];
			} else { /* You have found inversions here. */
				result[k] = right[b++];
				count += left.length - a;
			}
			k++;
		}

		if (a == left.length) {
			for (int i = b; i < right.length; i++) {
				result[k++] = right[i];
			}
		} else {
			for (int i = a; i < left.length; i++) {
				result[k++] = left[i];
			}
		}

		return count;
	}
}