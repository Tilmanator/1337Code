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
		List<Integer> n = new LinkedList<Integer>(curr);
		n.add(root.val);
		if (root.val == sum && root.right == null && root.left == null)
			ret.add(n);
		pathSumHelper(root.left, sum - root.val, ret, n);
		pathSumHelper(root.right, sum - root.val, ret, n);
	}

}
