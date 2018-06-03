package done;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		help(nums, 0, curr, ret);
		return ret;
	}

	public void help(int[] n, int index, List<Integer> curr, List<List<Integer>> ret) {
		// This is pass by reference issue without new
		ret.add(new ArrayList<Integer>(curr));

		// Go through all the possible options from the current point
		for (int i = index; i < n.length; ++i) {
			curr.add(n[i]);
			// Go through all possibilities with this number included
			help(n, i + 1, curr, ret);
			// Remove the current element and go through possibilities without it
			curr.remove(curr.size() - 1);
		}

	}

}
