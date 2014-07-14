package crousera.algorithms.part.two.week.first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JobUtil {
	private static final String SPACE = "\\s+";
	
	private JobUtil() {
	}
	
	public static List<Job> initializeJobsFromFile(File file) throws IOException {
		LinkedList<Job> jobs = new LinkedList<Job>();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			String[] splited = line.split(SPACE);
			if (splited.length > 1) {
				int weight = Integer.valueOf(splited[0]);
				int length = Integer.valueOf(splited[1]);
				Job job = new Job(weight, length);
				
				
				// Sorting while reading O = n^2
				double score = job.getScore();
				if (jobs.isEmpty()) {
					jobs.add(job); // adding the very first one
				} else {
					Job first = jobs.getFirst();
					Job last = jobs.getLast();
					
					if (score > first.getScore()) {
						jobs.addFirst(job);
					} else if (score < last.getScore()) {
						jobs.addLast(job);
					} else {
					    for (int i = 0; i < jobs.size(); i++) {
					    	Job currentJob = jobs.get(i);
					    	double currentScore = currentJob.getScore();
					    	int currentWeight = currentJob.getWeight();
					    	
					    	if (score == currentScore) {
					    		if (weight >= currentWeight) {
					    			jobs.add(i, job);
					    			break;
					    		} else {
					    			if (i + 1 == jobs.size()) {
						    			jobs.addLast(job);
					    			} else {
					    				for (int j = i + 1; j < jobs.size(); j++) {
						    				Job nextJob = jobs.get(j);
						    				double nextScore = nextJob.getScore();
						    				int nextWeight = nextJob.getWeight();
						    				
						    				if (score != nextScore) {
						    					jobs.add(j, job);
						    					break;
						    				} else if (weight >= nextWeight) {
						    					jobs.add(j, job);
						    					break;
						    				} 
						    			}	
					    			}
					    			break;
					    		}
					    	} else if (score > currentScore) {
					    		jobs.add(i, job);
					    		break;
					    	}
					    }
					}
				}
			}
		}
		br.close();
		return jobs;
	}
	
	public static long sumWeightedCompletionTime(List<Job> jobs) {
		long sum = 0;
		long time = 0;
		System.out.println("---- Scores & Weights----");
		for (int i = 0; i < jobs.size(); i++) {
			Job currentJob = jobs.get(i);
			System.out.println("Score: " + currentJob.getScore() + " / Weight: " + currentJob.getWeight() );
			time += currentJob.getLength();
			sum += time * currentJob.getWeight();
		}
		return sum;
	}
}
