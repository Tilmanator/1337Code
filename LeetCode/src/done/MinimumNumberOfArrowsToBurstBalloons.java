package done;

import java.util.Arrays;
import java.util.Comparator;

// Old way was with Tuples, extending the range...can avoid this by sorting on second value OR by iterating through it backwards
public class MinimumNumberOfArrowsToBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;

		// Sort array by second value to iterate through it from front to end,
		// tracking only the last value of the previous range
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});

		int arrows = 1;
		int lastEnd = points[0][1];

		for (int i = 1; i < points.length; ++i) {
			// Fits within previous range and we know its end is larger
			if (points[i][0] <= lastEnd)
				continue;

			// Otherwise we need to start a new range
			++arrows;
			lastEnd = points[i][1];
		}

		// Arrows can be fired anywhere in the ranges
		return arrows;
	}
}
