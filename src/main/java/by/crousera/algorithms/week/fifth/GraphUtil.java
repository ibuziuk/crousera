package by.crousera.algorithms.week.fifth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphUtil {

	public static Graph initGraphFromFile(String fileName) throws IOException {
		List<Vertex> vertecies = new ArrayList<Vertex>();
		List<Edge> edges = new ArrayList<Edge>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while((line = reader.readLine()) != null) {
			String[] parts = line.split("\\s+");
			Vertex tailVertex = new Vertex(Integer.parseInt(parts[0])); // first entry of the row is the vertex label/id
			vertecies.add(tailVertex);
			for (int i = 1; i < parts.length; i++) {
				String[] headAndWeight = parts[i].split(",");
				
				int head = Integer.parseInt(headAndWeight[0]); 
				int weight = Integer.parseInt(headAndWeight[1]);
				
				Vertex headVertex = new Vertex(head);
				Edge edge = new Edge(tailVertex, headVertex, weight);
				edges.add(edge);
			}
		}
		
		return new Graph(vertecies, edges);
	}
}
