package by.crousera.algorithms.week.third;

import java.io.IOException;

public class MinCutRunner implements Runnable {
	private static String fileName = "ProgrammingQuestions/week-3/kargerMinCut.txt";

	@Override
	public void run() {
		String workingDir = System.getProperty("user.dir"); // path to the root of the project
		int numberOfVertices = GraphUtil.getNumberOfVertices(workingDir + "/" + fileName);
		AdjacencyList adjacencyList = new AdjacencyList(numberOfVertices);

		try {
			GraphUtil.initializeGraph(adjacencyList, workingDir + "/" + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(GraphUtil.minCut(adjacencyList));
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			(new Thread(new MinCutRunner())).start();
		}
	}
}
