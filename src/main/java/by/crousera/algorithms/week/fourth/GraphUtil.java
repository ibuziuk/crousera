package by.crousera.algorithms.week.fourth;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.zip.ZipFile;

import javax.print.DocFlavor.INPUT_STREAM;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class GraphUtil {

	public static Set<Vertex> initVertecies(String fileName) throws IOException {
		File file = new File(fileName);
		if (file.exists()) {
			Map<Integer, Vertex> vertexMap = new HashMap<Integer, Vertex>();
			FileInputStream fileInputStream = new FileInputStream(file);
			Scanner scanner = new Scanner(fileInputStream);
			while (scanner.hasNext()) {
				int tailVertexLabel = scanner.nextInt();
				int headVertexLabel = scanner.nextInt();
				if (tailVertexLabel != headVertexLabel) {
					if (vertexMap.containsKey(tailVertexLabel)) {
						Vertex tailVertex = vertexMap.get(tailVertexLabel);
						Vertex headVertex = new Vertex(headVertexLabel);
						tailVertex.addEdgeTo(headVertex);
					} else {
						Vertex tailVertex = new Vertex(tailVertexLabel);
						Vertex headVertex = new Vertex(headVertexLabel);
						tailVertex.addEdgeTo(headVertex);
						vertexMap.put(tailVertexLabel, tailVertex);
					}
				}
			}
		}
		return null; // TODO
	}

	public static void addEdges(DirectedGraph<Integer, DefaultEdge> dg, InputStream inputStream) {
		Scanner sc = new Scanner(inputStream);
		while (sc.hasNext()) {
			dg.addEdge(sc.nextInt(), sc.nextInt());
		}
		sc.close();
	}
}
