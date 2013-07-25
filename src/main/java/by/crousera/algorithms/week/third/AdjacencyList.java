package by.crousera.algorithms.week.third;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdjacencyList {
	private List<Integer>[] graph; // graph is an array of lists; [0] -> 1, 3, 2

	public AdjacencyList(int numberOfVertices) { 
		graph = (List<Integer>[]) new List[numberOfVertices];
		for (int i = 0; i < numberOfVertices; i++) {
			graph[i] = new ArrayList<Integer>();
		}
	}
	
	public AdjacencyList(List<Integer>[] graph) {
		this.graph = graph;
	}

	public void addEdge(int i, int j) { // adding edge i -> j
		graph[i].add(j);
	}

	public void removeEdge(int i, int j) {
		Iterator<Integer> it = graph[i].iterator();
		while (it.hasNext()) {
			if (it.next() == j) {
				it.remove();
				return;
			}
		}
	}

	boolean hasEdge(int i, int j) {
		return graph[i].contains(j);
	}

	List<Integer> outEdges(int i) {
		return graph[i];
	}

	public List<Integer>[] getGraph() {
		return graph;
	}
	
	public void setGraph(List<Integer>[] graph) {
		this.graph = graph;
	}
}
