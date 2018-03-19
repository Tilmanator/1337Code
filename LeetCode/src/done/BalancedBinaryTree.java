package done;

public class BalancedBinaryTree {

	boolean balanced = true;

	public int depth(TreeNode root) {

		if (root == null)
			return 0;

		// Check the depth of the left/right subtrees
		int l = depth(root.left);
		int r = depth(root.right);
		// Once they are over 1 level apart, it is unbalanced
		if (Math.abs(l - r) > 1)
			balanced = false;

		// Return largest depth from current node
		return Math.max(l + 1, r + 1);
	}

	public boolean isBalanced(TreeNode root) {
		depth(root);
		return balanced;
	}

	public static void main(String[] a) {
		BalancedBinaryTree b = new BalancedBinaryTree();
		System.out.println(b.isBalanced(null));
	}
}
