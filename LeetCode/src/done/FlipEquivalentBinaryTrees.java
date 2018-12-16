package done;

public class FlipEquivalentBinaryTrees {
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		// Comparable nodes have the same values and have subtrees that are flip
		// equivalent
		return root1.val == root2.val && ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
				|| (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right)));
	}
}
