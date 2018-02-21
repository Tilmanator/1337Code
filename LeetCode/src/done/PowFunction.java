package done;

public class PowFunction {
	// Log n solution by noticing x^2 = x*x
	public double myPow(double x, int n) {
		// Special case since -n would be int overflow
		if (n == Integer.MIN_VALUE) {
			return myPow(x * x, n / 2);
		}
		if (n < 0) {
			return myPow(1 / x, -n);
		}
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n % 2 == 1)
			return myPow(x * x, n / 2) * x;
		return myPow(x * x, n / 2);
	}
}
