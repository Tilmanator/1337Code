package done;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	class Solution {
		public int minimumTotal(List<List<Integer>> triangle) {
			if (triangle.size() == 0)
				return 0;

			// Keep track of best paths in previous row
			List<Integer> curr = new ArrayList<>(triangle.get(0));

			for (int i = 1; i < triangle.size(); ++i) {
				List<Integer> temp = new ArrayList<>();
				temp.add(curr.get(0) + triangle.get(i).get(0));

				// Optimize by choosing min path
				for (int j = 1; j < triangle.get(i).size() - 1; ++j) {
					temp.add(triangle.get(i).get(j) + Math.min(curr.get(j - 1), curr.get(j)));
				}
				temp.add(curr.get(curr.size() - 1) + triangle.get(i).get(triangle.get(i).size() - 1));
				curr = temp;
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < curr.size(); ++i) {
				min = Math.min(min, curr.get(i));
			}
			return min;
		}
	}
}
