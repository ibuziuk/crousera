package by.crousera.algorithms.week.second;

import java.io.IOException;
import java.util.Arrays;

import by.crousera.algorithms.util.AlgorithmsUtil;

public class ComparisonsCounterRunner {
	private static String fileName = "ProgrammingQuestions/week-2/QuickSort.txt";
	
	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir"); // path to the root of the project

		try {
			int[] originalArray = AlgorithmsUtil.fileToIntArray(workingDir + "/" + fileName);
 			QuickSort quickSort = new QuickSort();
			quickSort.sort(originalArray);
			System.out.println("Number of comparisons: " + quickSort.getComparisonCounter());
		} catch (IOException e) {
			e.printStackTrace();
		}				
 	}
}
