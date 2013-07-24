package by.crousera.algorithms.week.third;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdjacencyList {
	private int n; // number of vertices
	private List<Integer>[] graph; // graph is an array of lists

	public AdjacencyList(int n) {
		this.n = n; 
		graph = (List<Integer>[]) new List[n + 1]; // HACK - I'm really sorry for that (first element of the array will be null)
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
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

	public int getN() {
		return n;
	}
}
