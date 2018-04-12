package done;

public class DecodeWays {
	public int numDecodings(String s) {

		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		// We only care about previous two values
		// The first numbers will have a count of 1, so initialize prev
		// accordingly
		int prev_prev = 1, prev = 1;

		for (int i = 1; i < s.length(); ++i) {
			int temp = 0;
			// Valid single digit, add ways to get to previous digit
			if (s.charAt(i) != '0')
				temp += prev;
			// Valid previous two digits, add ways to get to the digit 2 before
			if (valid(s.charAt(i - 1), s.charAt(i)))
				temp += prev_prev;

			prev_prev = prev;
			prev = temp;
		}

		return prev;

	}

	// Optimize character comparisons
	public static boolean valid(char a, char b) {
		if ((a == '1' && b >= '0' && b <= '9') || (a == '2' && b >= '0' && b <= '6'))
			return true;
		return false;
	}
}
