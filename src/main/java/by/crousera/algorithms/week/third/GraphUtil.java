package by.crousera.algorithms.week.third;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class GraphUtil {

	public static int getNumberOfVertices(String fileName) {
		int numberOflines = 0;
		try {
			File file = new File(fileName);
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				LineNumberReader lnr = new LineNumberReader(fr);
				while (lnr.readLine() != null) {
					numberOflines++;
				}
				lnr.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numberOflines; // number of lines = number of vertices;
	}
	
	public static void initializeGraph(AdjacencyList adjacencyList, String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while((line = reader.readLine()) != null) {
			String[] parts = line.split("\\s+");
			int verticesIndex = Integer.valueOf(parts[0]);
			for (int i = 1; i < parts.length; i++) {
				adjacencyList.addEdge(verticesIndex, Integer.valueOf(parts[i]));
			}
		}
	}
}
