package done;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

	Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

	public int rob(TreeNode root) {
		// Memoization since multiple calls can be made for a node
		if (map.containsKey(root))
			return map.get(root);

		if (root == null)
			return 0;
		int includeCurrent = root.val;
		if (root.left != null)
			includeCurrent += rob(root.left.left) + rob(root.left.right);
		if (root.right != null)
			includeCurrent += rob(root.right.left) + rob(root.right.right);

		int skipCurr = rob(root.left) + rob(root.right);

		map.put(root, Math.max(includeCurrent, skipCurr));
		return map.get(root);
	}
}
