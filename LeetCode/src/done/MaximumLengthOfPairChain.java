package done;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
	public int findLongestChain(int[][] pairs) {

		// Sort by endpoint
		Arrays.sort(pairs, (a, b) -> {
			return a[1] - b[1];
		});

		int end = pairs[0][1];
		int max = 1;
		// Greedy solution
		for (int i = 1; i < pairs.length; ++i) {
			if (pairs[i][0] > end) {
				max++;
				end = pairs[i][1];
			}
		}

		return max;
	}
}
