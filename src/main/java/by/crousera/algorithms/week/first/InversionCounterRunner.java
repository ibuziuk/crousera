package by.crousera.algorithms.week.first;

import java.io.IOException;

import by.crousera.algorithms.week.first.util.InversionUtil;

public class InversionCounterRunner {
	private static String fileName = "IntegerArray.txt";

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir"); // path to the root of the project
		
		try {
			int[] originalArray = InversionUtil.fileToIntArray(workingDir + "/" + fileName);
			System.out.println("Array's length: " + originalArray.length);
			System.out.println("Number of inversions: " + SmartInversionCounter.countInversions(originalArray));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
