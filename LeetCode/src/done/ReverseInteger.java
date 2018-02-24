package done;

public class ReverseInteger {

	public static int reverse(int x) {
		int ret = 0;
		// Dealing with sign
		int mult = x < 0 ? -1 : 1;
		x = Math.abs(x);

		while (x > 0) {
			int temp = ret;
			ret *= 10;
			ret += x % 10;
			x /= 10;
			// If overflow has occurred we know the value was too large
			if (ret / 10 != temp)
				return 0;

		}
		return mult * ret;
	}

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));

	}

}
