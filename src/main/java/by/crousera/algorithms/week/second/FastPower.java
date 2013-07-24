package by.crousera.algorithms.week.second;

public class FastPower {
	
	public static int fastPower(int a, int b) {
		if (b == 1) {
			return a;
		}
		
		int c = a*a;
		int ans = fastPower(c, b/2);
		
		if ((b&1) != 0) {
			return a*ans;
		} else {
			return ans;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(fastPower(2, 6));	
	}
}
