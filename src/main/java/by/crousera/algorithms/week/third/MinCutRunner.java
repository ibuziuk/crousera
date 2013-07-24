package by.crousera.algorithms.week.third;

import java.io.IOException;

public class MinCutRunner {
	private static String fileName = "ProgrammingQuestions/week-3/kargerMinCut.txt";

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir"); // path to the root of the project
		int numberOfVertices = GraphUtil.getNumberOfVertices(workingDir + "/" + fileName);
		AdjacencyList adjacencyList = new AdjacencyList(numberOfVertices);
		
		try {
			GraphUtil.initializeGraph(adjacencyList, workingDir + "/" + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
