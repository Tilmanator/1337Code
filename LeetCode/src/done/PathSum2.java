package done;

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {

	// Run helper function
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new LinkedList<>();
		pathSumHelper(root, sum, ret, new LinkedList<Integer>());
		return ret;
	}

	// If the current leaf has the right remaining sum, append current list as a
	// solution
	public static void pathSumHelper(TreeNode root, int sum, List<List<Integer>> ret, List<Integer> curr) {
		if (root == null)
			return;
		curr.add(root.val);
		if (root.val == sum && root.right == null && root.left == null)
			ret.add(new LinkedList<Integer>(curr));
		pathSumHelper(root.left, sum - root.val, ret, curr);
		pathSumHelper(root.right, sum - root.val, ret, curr);
		// Simply pop off the current value when done with it and continue
		// traversing tree
		curr.remove(curr.size() - 1);
	}

}
