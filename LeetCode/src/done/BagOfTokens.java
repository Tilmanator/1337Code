package done;

import java.util.Arrays;

public class BagOfTokens {
	public int bagOfTokensScore(int[] tokens, int P) {
		Arrays.sort(tokens);

		int max = 0, score = 0, lo = 0, hi = tokens.length - 1;

		while (lo <= hi) {
			if (tokens[lo] <= P) {
				++score;
				P -= tokens[lo++];
			} else if (score >= 1) {
				--score;
				P += tokens[hi--];
			} else {
				return max;
			}
			max = Math.max(score, max);
		}
		return max;
	}
}
