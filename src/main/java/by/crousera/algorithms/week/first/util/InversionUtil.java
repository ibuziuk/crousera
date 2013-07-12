package by.crousera.algorithms.week.first.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class InversionUtil {
    
	public static int[] fileToIntArray(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> numbers = new ArrayList<Integer>();
        String line = null;
        int number;
        while ((line = bufferedReader.readLine()) != null) {
        	number = Integer.parseInt(line);
            numbers.add(number);
        }
        bufferedReader.close();
        return ArrayUtils.toPrimitive(numbers.toArray(new Integer[numbers.size()]));
    }
}
