package by.crousera.algorithms.week.fifth;

public class Edge {
	private final Vertex tail;
	private final Vertex head;
	private final int weight;

	public Edge(Vertex tail, Vertex head, int weight) {
		this.tail = tail;
		this.head = head;
		this.weight = weight;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (tail == null) {
			if (other.tail != null)
				return false;
		} else if (!tail.equals(other.tail))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	public Vertex getTail() {
		return tail;
	}

	public Vertex getHead() {
		return head;
	}

	public int getWeight() {
		return weight;
	}

}
