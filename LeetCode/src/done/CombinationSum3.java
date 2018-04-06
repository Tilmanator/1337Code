package done;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ret = new ArrayList<>();
		backtrack(ret, new ArrayList<Integer>(), n, k, 1);
		return ret;
	}

	public static void backtrack(List<List<Integer>> ret, List<Integer> curr, int target, int count, int start) {
		// Found the target by summing count numbers
		if (count == 0 && target == 0)
			ret.add(new ArrayList<Integer>(curr));
		if (count <= 0 || target > 9 * count || target <= 0)
			return;

		// Cannot use duplicate number so start next iteration
		for (int i = start; i < 10; ++i) {
			// Try using current number
			curr.add(i);
			backtrack(ret, curr, target - i, count - 1, i + 1);
			// Now try with next biggest number, excluding current
			curr.remove(curr.size() - 1);
		}
	}
}
