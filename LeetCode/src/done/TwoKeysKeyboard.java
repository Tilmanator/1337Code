package done;

public class TwoKeysKeyboard {
	// Minimum steps equal to sum of prime divisors
	public int minSteps(int n) {
		if (n == 1)
			return 0;
		return sumOfDivisors(n, 2);
	}

	// Add all prime divisors, probably a better way to do this
	public static int sumOfDivisors(int n, int s) {
		if (n == 1)
			return 1;
		int bound = (int) Math.sqrt(n);
		for (int i = s; i <= bound; ++i) {
			if (n % i == 0)
				return i + sumOfDivisors(n / i, i);
		}
		return n;
	}
}
