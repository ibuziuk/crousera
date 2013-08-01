package by.crousera.algorithms.week.fourth;

import java.io.IOException;
import java.util.List;
import java.util.zip.ZipFile;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;


public class SCCRunner {
	private static String fileName = "ProgrammingQuestions/week-4/SCC.zip";
	
	public static void main(String[] args) throws IOException {
		String workingDir = System.getProperty("user.dir"); // path to the root of the project
        ZipFile zf = new ZipFile( workingDir + "/" + fileName );
		DirectedGraph<Integer, DefaultEdge> directedGraph = new DefaultDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);
		for (int i = 1; i < 875715; i++) {
			directedGraph.addVertex(i);
		}
		by.crousera.algorithms.week.fourth.GraphUtil.addEdges(directedGraph,  zf.getInputStream( zf.getEntry( "SCC.txt" )));
		StrongConnectivityInspector sci = new StrongConnectivityInspector(directedGraph);
		List stronglyConnectedSubgraphs = sci.stronglyConnectedSubgraphs(); // I wasn't able to count scc even with jgrapht lib
	}
}
