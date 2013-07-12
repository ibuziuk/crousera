package by.crousera.algorithms.week.first;

import java.io.IOException;
import java.util.Arrays;

import by.crousera.algorithms.week.first.util.InversionUtil;

public class InversionCounterRunner {
	private static String fileName = "IntegerArray.txt";

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir"); // path to the root of the project
		
		try {
			int[] originalArray = InversionUtil.fileToIntArray(workingDir + "/" + fileName);
			Mergesort mergesort = new Mergesort();
			mergesort.sort(originalArray);
			System.out.println("Array's length: " + originalArray.length);
			System.out.println(Arrays.toString(mergesort.getNumbers()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
