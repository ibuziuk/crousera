package by.crousera.algorithms.week.sixth;

import java.io.IOException;
import java.util.Arrays;

import by.crousera.algorithms.util.AlgorithmsUtil;

public class MedianMaintenanceRunner {
	private static final String FILE_NAME = "ProgrammingQuestions/week-6/Median.txt";

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir"); // path to the root of the project
		try {
			int medianCounter = 0;
			int[] originalArray = AlgorithmsUtil.fileToIntArray(workingDir + "/" + FILE_NAME);

			for (int i = 0; i < originalArray.length; i++) {
				int[] proccessedArray = Arrays.copyOfRange(originalArray, 0, i + 1);
				Arrays.sort(proccessedArray);
				if ((i + 1) % 2 == 0) { // even
					medianCounter += proccessedArray[i / 2];
				} else { // odd
					medianCounter += proccessedArray[(i + 1) / 2];
				}
			}

			System.out.println("Length: " + originalArray.length);
			System.out.println(Arrays.toString(originalArray));
			System.out.println("Median Conter: " + medianCounter);
			System.out.println("Answer: " + (medianCounter % 10000) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
