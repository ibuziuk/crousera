package by.crousera.algorithms.week.fourth;

public class Edge {
	private Vertex tail;
	private Vertex head;
	
	public Edge(Vertex tail, Vertex head) {
		if (tail == null || head == null) {
			throw new IllegalArgumentException( "Both vertices are required" );
		}
		this.setTail(tail);
		this.setHead(head);
	}

	public Vertex getTail() {
		return tail;
	}

	public void setTail(Vertex tail) {
		this.tail = tail;
	}

	public Vertex getHead() {
		return head;
	}

	public void setHead(Vertex head) {
		this.head = head;
	}
	
} 
