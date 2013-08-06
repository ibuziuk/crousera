package by.crousera.algorithms.week.fifth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * The Implementation of the DijkstraAlgorithm was partly taken from http://www.vogella.com/articles/JavaAlgorithmsDijkstra/article.html 
 */

public class DijkstraAlgorithm {
	private final List<Vertex> vertecies;
	private final List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;
	private Map<Vertex, Integer> distance;
	private Map<Vertex, Vertex> predecessors;
	private Vertex sourceVertex;

	public DijkstraAlgorithm(Graph graph) {
		this.vertecies = new ArrayList<Vertex>(graph.getVertecies());
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}

	public void execute(Vertex sourceVertex) {
		this.sourceVertex = sourceVertex;
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();
		distance = new HashMap<Vertex, Integer>();
		predecessors = new HashMap<Vertex, Vertex>();

		distance.put(sourceVertex, 0);
		unSettledNodes.add(sourceVertex);

		while (unSettledNodes.size() > 0) {
			Vertex minNode = getMinimum(unSettledNodes);
			settledNodes.add(minNode);
			unSettledNodes.remove(minNode);
			findMinimalDistances(minNode);
		}
	}

	private void findMinimalDistances(Vertex minNode) {
		List<Vertex> adjacentNodes = getNeighbors(minNode);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(minNode) + getDistance(minNode, target)) {
				distance.put(target, getShortestDistance(minNode) + getDistance(minNode, target));
				predecessors.put(target, minNode);
				unSettledNodes.add(target);
			}
		}

	}

	private int getDistance(Vertex minNode, Vertex target) {
		for (Edge e : edges) {
			if (e.getTail().equals(minNode) && e.getHead().equals(target)) {
				return e.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Vertex> getNeighbors(Vertex minNode) {
		List<Vertex> neighborsVertecies = new ArrayList<Vertex>();
		for (Edge e : edges) {
			if (e.getTail().equals(minNode) && !isSettled(e.getHead())) {
				neighborsVertecies.add(e.getHead());
			}
		}
		return neighborsVertecies;
	}

	private Vertex getMinimum(Set<Vertex> vertecies) {
		Vertex minVertex = null;
		for (Vertex v : vertecies) {
			if (minVertex == null) {
				minVertex = v;
			} else {
				if (getShortestDistance(v) < getShortestDistance(minVertex)) {
					minVertex = v;
				}
			}
		}

		return minVertex;
	}

	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		// Check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

	private int getShortestDistance(Vertex destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	private boolean isSettled(Vertex vertex) {
		return settledNodes.contains(vertex);
	}

	public int getWeight(LinkedList<Vertex> path) {
		int weight = 0;
		Vertex source = sourceVertex;
		for (Vertex v : path) {
			if (!v.equals(source)) {
				weight += getWeight(source, v);
				source = v;
			}
		}
		return weight;
	}

	private int getWeight(Vertex tail, Vertex head) {
		for (Edge e : edges) {
			if (e.getTail().equals(tail) && e.getHead().equals(head)) {
				return e.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}
}
