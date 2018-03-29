package done;

import java.util.ArrayList;
import java.util.List;

// Backtracking question
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<>();
		backtrack(ret, n, k, new ArrayList<Integer>(), 1);
		return ret;
	}

	public static void backtrack(List<List<Integer>> ret, int n, int k, List<Integer> curr, int num) {
		if (curr.size() == k) {
			ret.add(new ArrayList<Integer>(curr));
			return;
		}

		for (int i = num; i < n; ++i) {
			// iterate through remaining possibilities with current element
			curr.add(i);
			backtrack(ret, n, k, curr, i + 1);
			// Try combinations with excluding element
			curr.remove(curr.size() - 1);
		}
	}
}
