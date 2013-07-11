package by.crousera.algorithms.week.first;

import java.io.IOException;
import java.util.Arrays;

public class InversionCounterRunner {
	private static String fileName = "IntegerArray.txt";

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir"); // root of the project
		InversionCounter inversionCounter = new InversionCounter();
		try {
			int[] originalArray = inversionCounter.fileToIntArray(workingDir + "/" + fileName);
			System.out.println("Array's length: " + originalArray.length);
			System.out.println(Arrays.toString(originalArray));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
