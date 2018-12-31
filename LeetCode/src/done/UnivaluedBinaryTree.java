package done;

public class UnivaluedBinaryTree {

	public boolean isUnivalTree(TreeNode root) {
		if (root == null)
			return true;
		return help(root.left, root.val) && help(root.right, root.val);
	}

	public static boolean help(TreeNode r, int val) {
		if (r == null)
			return true;
		return r.val == val && help(r.left, val) && help(r.right, val);
	}
}
