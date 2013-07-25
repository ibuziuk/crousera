package by.crousera.algorithms.week.third;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections.ListUtils;

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
			int verticesIndex = Integer.valueOf(parts[0]) - 1; // I need this '-1' for starting array with [0] not [1] 
			for (int i = 1; i < parts.length; i++) {
				adjacencyList.addEdge(verticesIndex, Integer.valueOf(parts[i]) - 1); // '-1' for correct vertices references ^ 
			}
		}
	}
	
	public static int minCut(AdjacencyList adjacencyList) {
		Random random = new Random();
		List<Integer>[] graph = adjacencyList.getGraph();
		Set<Integer> setWithDeletedVertices = new HashSet<Integer>();
		
		while(setWithDeletedVertices.size() < (graph.length - 2)) {
			int m = random.nextInt(graph.length);
			int numberOfVertices = graph[m].size();
			
			if (numberOfVertices > 0) {
				int n = graph[m].get(random.nextInt(graph[m].size()));
				if ((n != m) && !setWithDeletedVertices.contains(n) && !setWithDeletedVertices.contains(m)) {
					int smallestVertice = (n < m) ? n : m;
					int biggestVertice = (smallestVertice == n) ? m : n;

					// 1) remove edge
					while (graph[m].contains(n)) {
						removeEdge(graph, m, n);
					}

					while (graph[n].contains(m)) {
						removeEdge(graph, n, m);
					}

					// 2) merge 2 vertices into 1
					List<Integer> mergedVertice = ListUtils.union(graph[m], graph[n]);
					graph[smallestVertice] = mergedVertice;
					
					// 3) replacement for correct vertices references
					for (int i = 0; i < graph.length; i++) {
						Collections.replaceAll(graph[i], biggestVertice, smallestVertice); 
					}

					// 4) need to expel biggest vertex
					setWithDeletedVertices.add(biggestVertice);
				}
			}
		}
		
		return graph[0].size(); // in the end the List graph[0] would have all edge references, because of the replacement (biggest -> smallest) 
	}
		
	public static void removeEdge(List<Integer>[] graph ,int i, int j) {
		Iterator<Integer> it = graph[i].iterator();
		while (it.hasNext()) {
			if (it.next() == j) {
				it.remove();
				return;
			}
		}
	}
}
