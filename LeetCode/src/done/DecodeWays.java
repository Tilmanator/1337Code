package done;

public class DecodeWays {
	public int numDecodings(String s) {

		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		// Could use dp array, but we only care about previous two values
		int prev_prev = 1, prev = 1;

		for (int i = 1; i < s.length(); ++i) {
			int temp = 0;
			// Valid single digit, add ways to get to previous digit
			if (s.charAt(i) != '0')
				temp += prev;
			// Valid previous two digits, add ways to get to the digit 2 before
			if (valid(s.substring(i - 1, i + 1)))
				temp += prev_prev;

			prev_prev = prev;
			prev = temp;
		}

		return prev;

	}

	public static boolean valid(String s) {
		if (Integer.parseInt(s) <= 26 && Integer.parseInt(s) >= 10)
			return true;
		return false;
	}
}
