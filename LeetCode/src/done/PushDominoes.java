package done;

public class PushDominoes {
	public String pushDominoes(String dominoes) {
		char[] out = dominoes.toCharArray();
		boolean r = false;
		int leftIndex = 0;

		for (int i = 0; i < dominoes.length(); ++i) {

			// Try to extend L on the left
			if (dominoes.charAt(i) == 'L' && !r) {
				for (int j = leftIndex; j < i; ++j)
					out[j] = 'L';
			}
			if (dominoes.charAt(i) == 'L') {
				r = false;
				leftIndex = i;
			}
			if (dominoes.charAt(i) == 'R') {
				r = true;
				int start = i;
				++i;
				// Try to extend R on the right
				while (i < dominoes.length() && dominoes.charAt(i) == '.') {
					out[i] = 'R';
					++i;
				}
				if (i == dominoes.length()) {
					break;
				}
				// Start from the next R
				else if (dominoes.charAt(i) == 'R') {
					--i;
					continue;
				}
				// Fill halfway
				if (dominoes.charAt(i) == 'L') {
					for (int j = 0; j < (i - start) / 2; ++j)
						out[i - 1 - j] = 'L';

					// If middle doesn't tip
					if ((i - start) % 2 == 0) {
						out[start + (i + 1 - start) / 2] = '.';
					}
				}

				--i;
			}
		}

		return new String(out);
	}
}
