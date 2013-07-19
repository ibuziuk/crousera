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
		comparisonCounter += (high - low);
		
		int firstIndex = low;
		int lastIndex  = high;
		int middleIndex = low + (high-low) / 2;
		int pivotIndex = getMedianIndex(firstIndex, lastIndex, middleIndex);
		
//		exchange(low, pivotIndex); // uncomment if pivot is the median element 
//		exchange(low, high); // uncomment if pivot is the very last element 
		
		int pivot = sortedArray[low];  
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
	
	private int getMedianIndex(int a, int b, int c) { // 3rd Task - getting median element index (median element is a pivot)
		int pivotIndex;
		if (sortedArray[a] > sortedArray[b]) {
			if(sortedArray[b] > sortedArray[c]) {
				pivotIndex = b;
			} else if (sortedArray[a] > sortedArray[c]) {
				pivotIndex = c;
			} else {
				pivotIndex = a;
			}
		} else {
			if(sortedArray[a] > sortedArray[c]) {
				pivotIndex = a;
			} else if (sortedArray[b] > sortedArray[c]) {
				pivotIndex = c;
			} else {
				pivotIndex = b;
			}
		}
		return pivotIndex;
	}

	private void exchange(int i, int j) {
		int temp = sortedArray[i];
		sortedArray[i] = sortedArray[j];
		sortedArray[j] = temp;
	}
	
	public int[] getSortedArray() {
		return this.sortedArray;
	}
	
	public int getComparisonCounter() {
		return this.comparisonCounter;
	}
}
