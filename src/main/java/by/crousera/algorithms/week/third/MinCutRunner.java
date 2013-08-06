package by.crousera.algorithms.week.third;

import java.io.IOException;

public class MinCutRunner implements Runnable {
	private static final String FILE_NAME = "ProgrammingQuestions/week-3/kargerMinCut.txt";

	@Override
	public void run() {
		String workingDir = System.getProperty("user.dir"); // path to the root of the project
		int numberOfVertices = GraphUtil.getNumberOfVertices(workingDir + "/" + FILE_NAME);
		AdjacencyList adjacencyList = new AdjacencyList(numberOfVertices);

		try {
			GraphUtil.initializeGraph(adjacencyList, workingDir + "/" + FILE_NAME);
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
