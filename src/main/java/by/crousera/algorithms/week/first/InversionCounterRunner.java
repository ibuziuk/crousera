package by.crousera.algorithms.week.first;

import java.io.IOException;

import by.crousera.algorithms.util.AlgorithmsUtil;

public class InversionCounterRunner {
	private static final String FILE_NAME = "ProgrammingQuestions/week-1/IntegerArray.txt";

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir"); // path to the root of the project
		
		try {
			int[] originalArray = AlgorithmsUtil.fileToIntArray(workingDir + "/" + FILE_NAME);
			System.out.println("Array's length: " + originalArray.length);
			System.out.println("Number of inversions: " + SmartInversionCounter.countInversions(originalArray));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
