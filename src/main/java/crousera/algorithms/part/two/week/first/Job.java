package crousera.algorithms.part.two.week.first;

public class Job {
	private int weight;
	private int length;
	private double score;

	public Job(int weight, int length) {
		this.weight = weight;
		this.length = length;
		this.score = weight * 1.0 / length; // NOTE: for the first task need to use `weight - length` (score of int type)
	}

	public int getWeight() {
		return weight;
	}

	public int getLength() {
		return length;
	}

	public double getScore() {
		return score;
	}
}
