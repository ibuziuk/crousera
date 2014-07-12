package crousera.algorithms.part.two.week.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MinimizeWeightedSumRunner {
	private static final String PROJECT_PATH = System.getProperty("user.dir"); // path to the root of the project
	private static final String FILE_PROJECT_RELATIVE_PATH = "ProgrammingQuestions/part 2/week-1/jobs.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(PROJECT_PATH, FILE_PROJECT_RELATIVE_PATH);
		if (file != null && file.exists()) {
			List<Job> jobs = JobUtil.initializeJobsFromFile(file);
			long minimizeWeightedSum = JobUtil.sumWeightedCompletionTime(jobs);
			System.out.println(minimizeWeightedSum);
		} else {
			throw new FileNotFoundException();
		}
	}

}
