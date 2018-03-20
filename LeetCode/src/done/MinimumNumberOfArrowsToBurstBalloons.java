package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumNumberOfArrowsToBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;

		// Sort the input array to ensure we don't miss solutions due to the
		// order of balloons (ex: 2:3, 3:4, 1:2, 4:5 needs 2 not 3)
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});

		// Keep track of what we have
		List<Tuple> range = new ArrayList<Tuple>();
		range.add(new Tuple(points[0][0], points[0][1]));
		for (int i = 1; i < points.length; ++i) {
			// The new point fits in the range of the old one
			if (points[i][0] <= range.get(range.size() - 1).y) {
				// The new x is guaranteed to be >=
				range.get(range.size() - 1).x = points[i][0];
				// Reduce the range if necessary
				range.get(range.size() - 1).y = Math.min(points[i][1], range.get(range.size() - 1).y);
			} else {
				range.add(new Tuple(points[i][0], points[i][1]));
			}
		}

		// Arrows can be fired anywhere in the ranges
		return range.size();
	}
}

class Tuple {
	int x;
	int y;

	Tuple(int a, int b) {
		x = a;
		y = b;
	}
}
