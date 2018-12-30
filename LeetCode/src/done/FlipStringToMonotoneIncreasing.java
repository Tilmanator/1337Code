package done;

public class FlipStringToMonotoneIncreasing {
	public int minFlipsMonoIncr(String S) {
		boolean zeros = true;
		int flip1 = 0, flip0 = 0;

		for (int i = 0; i < S.length(); ++i) {
			if (S.charAt(i) == '0') {
				// 0s at the start don't count
				if (zeros)
					continue;
				++flip0;
			} else {
				++flip1;
				zeros = false;
			}

			// By returning the flip0 count, we can ignore any 1s at the end
			// Check whether it's better to flip 1s to 0s
			flip0 = Math.min(flip0, flip1);
		}

		return flip0;

	}
}
