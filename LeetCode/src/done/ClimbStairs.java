package done;

public class ClimbStairs {
	public int climbStairs(int n) {
		if (n <= 3)
			return n;

		int twoAgo = 1; // Starts at 1, 1 way to get there
		int prev = 2; // Starts at 1, 2 ways to get to 2

		// At each point, num ways is sum of previous two steps
		// Then update the previous steps
		for (int i = 3; i < n; ++i) {
			int temp = twoAgo;
			twoAgo = prev;
			prev += temp;
		}
		return prev + twoAgo;
	}
}
