package by.crousera.algorithms.week.fourth;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
	private int label;
	private final Set<Edge> edges = new HashSet<Edge>();
	
	public Vertex(int label) {
		this.label = label;
	}
	
	public void addEdgeTo(Vertex vertex) {
		Edge edge = new Edge(this, vertex);
		edges.add(edge);
	}
			
	public int getLabel() {
		return this.label;
	}
	
	public Set<Edge> getEdges() {
		return edges;
	}
	
	public boolean equals(Vertex vertex) {
		return (this.label == vertex.label) ? true : false;
	}
}
