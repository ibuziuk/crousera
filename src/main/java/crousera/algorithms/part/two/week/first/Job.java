package crousera.algorithms.part.two.week.first;

public class Job {
	private int weight;
	private int length;
	private int score;

	public Job(int weight, int length) {
		this.weight = weight;
		this.length = length;
		this.score = weight - length; // NOTE: for the second task need to use `weight / length` (score is a float type)
	}

	public int getWeight() {
		return weight;
	}

	public int getLength() {
		return length;
	}

	public int getScore() {
		return score;
	}
}
