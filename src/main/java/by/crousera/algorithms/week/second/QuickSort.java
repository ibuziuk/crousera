package by.crousera.algorithms.week.second;

public class QuickSort {
	private int[] sortedArray;
	private int comparisonCounter;
	
	public void sort(int[] originalArray) {
		if (originalArray == null || originalArray.length == 1) {
			return;
		}
		this.sortedArray = originalArray;
		int lastIndex = originalArray.length - 1;
		quickSort(0, lastIndex);
	}
	
	private void quickSort(int low, int high) {
		if (low >= high) {
			return;
		}
		
		int pivot = sortedArray[low];  // pivot is the very first element
//		int pivot = sortedArray[high]; // pivot is the very last element
//		int pivot = sortedArray[low + (high-low) / 2]; // pivot is the middle element of the array // TODO check !!! 
		
		int i = low + 1;
		
		for(int j = low + 1; j <= high; j++) {
			if (sortedArray[j] > pivot) {
				// do nothing 
			} else {
			  // 1. swapping elements	
			  exchange(i, j);
			  // 2. increment i
			  i++;
			}
		}

		// swap the pivot with i 
		exchange(low, i - 1);
		quickSort(low, i - 2);
		quickSort(i, high);
	}
	
	private void exchange(int i, int j) {
		int temp = sortedArray[i];
		sortedArray[i] = sortedArray[j];
		sortedArray[j] = temp;
	}
	
	public int[] getArray() {
		return this.sortedArray;
	}
	
	public int getComparisonCounter() {
		return this.comparisonCounter;
	}
}
