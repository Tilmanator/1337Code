package done;

public class DiameterOfBinaryTree {

	public int length(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(length(root.right), length(root.left));
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		// Check whether the current node should be included or not
		return Math.max(length(root.left) + length(root.right),
				Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));

	}
}
