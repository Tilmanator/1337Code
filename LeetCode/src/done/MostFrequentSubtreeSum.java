package done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
	class Solution {
		// Keep the count of a sum and the maximum count so we can easily look
		// up solutions
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;

		public int[] findFrequentTreeSum(TreeNode root) {
			// Calculate all sums
			dfs(root);
			List<Integer> ret = new ArrayList<Integer>();

			// Find all elements that must be returned
			for (Integer key : map.keySet()) {
				if (map.get(key) == max) {
					ret.add(key);
				}
			}
			int[] r = new int[ret.size()];
			int idx = 0;
			for (Integer i : ret) {
				r[idx++] = i;
			}
			return r;
		}

		public int dfs(TreeNode root) {
			if (root == null)
				return 0;
			// Post order traversal
			int subtreeSum = root.val + dfs(root.left) + dfs(root.right);
			int curr = map.getOrDefault(subtreeSum, 0) + 1;
			// Update map and max (if necessary)
			map.put(subtreeSum, curr);
			max = curr > max ? curr : max;
			return subtreeSum;
		}
	}
}
