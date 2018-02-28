package done;

public class GasStation {

	// Helper to check whether current state could work
	// Simply go through until the next point cant't be reached
	public static boolean works(int[] g, int s) {
		int total = g[s];
		int counter = 0;

		while (total >= 0 && counter < g.length) {
			++s;
			++counter;
			if (s == g.length)
				s = 0;
			total += g[s];
		}
		if (counter == g.length)
			return true;
		return false;
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {

		// Think of each step as the net gain/loss in gas
		for (int i = 0; i < cost.length; ++i)
			gas[i] -= cost[i];

		// Brute force every possibility
		for (int i = 0; i < gas.length; ++i) {
			if (works(gas, i))
				return i;
		}
		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = { 2 };
		int[] p = { 2 };
		System.out.println(canCompleteCircuit(t, p));
	}

}
