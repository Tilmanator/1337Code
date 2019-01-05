package done;

import java.awt.Point;
import java.util.Arrays;
import java.util.TreeMap;

public class MostProfitAssigningWork {
	class Solution {
		public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
			Point[] t = new Point[difficulty.length];

			// Sort by difficulty
			for (int i = 0; i < difficulty.length; ++i) {
				t[i] = new Point(difficulty[i], profit[i]);
			}
			Arrays.sort(t, (a, b) -> a.x - b.x);

			// Make a tree map, keeping the invariant that if difficulty[i] <
			// difficulty[j], profit[i] < profit[j]
			TreeMap<Integer, Integer> map = new TreeMap<>();

			for (int i = 0; i < difficulty.length; ++i) {
				int diff = t[i].x;
				int prof = t[i].y;

				if (map.isEmpty() || map.get(map.floorKey(diff)) < prof) {
					map.put(diff, prof);
				}
			}
			int res = 0;
			int min = map.firstKey();
			for (int w : worker) {
				if (w >= min)
					res += map.get(map.floorKey(w));
			}

			return res;
		}
	}
}
