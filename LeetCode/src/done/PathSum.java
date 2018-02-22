package done;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		// Ensure it's a leaf 
		if (root.val == sum && root.right == null && root.left == null)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
