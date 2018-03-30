package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		// Sort array first to make duplicate checking easier
		Arrays.sort(candidates);

		// Add index to start from, to backtracking since array is sorted
		backtrack(ret, new ArrayList<Integer>(), candidates, target, 0);
		return ret;
	}

	public static void backtrack(List<List<Integer>> ret, List<Integer> curr, int[] candy, int tar, int idx) {
		if (tar == 0) {
			ret.add(new ArrayList<Integer>(curr));
			return;
		}

		for (int i = idx; i < candy.length; ++i) {
			// Skip duplicates here and ensure it could be a valid solution
			if (tar - candy[i] >= 0 && (i < 1 || candy[i] != candy[i - 1])) {
				curr.add(candy[i]);
				backtrack(ret, curr, candy, tar - candy[i], i);
				curr.remove(curr.size() - 1);
			}
		}
	}
}
