package done;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		// Check pairs
		return help(root.left, root.right);
	}

	public boolean help(TreeNode l, TreeNode r) {
		if (l == null && r == null)
			return true;
		if ((l == null && r != null) || (l != null && r == null))
			return false;
		// Check if the vals are the same and their children (recursively) are
		// symmetric
		return l.val == r.val && help(l.left, r.right) && help(l.right, r.left);

	}
}
