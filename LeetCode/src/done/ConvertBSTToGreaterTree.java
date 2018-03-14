package done;

public class ConvertBSTToGreaterTree {
	public int sum = 0;

	// Reverse in-order traversal
	public void inOrder(TreeNode root) {
		// Go down right subtree and add to the current sum
		if (root.right != null)
			inOrder(root.right);

		// Process current node
		int temp = root.val;
		root.val += sum;
		sum += temp;

		// Continue down left subtree
		if (root.left != null)
			inOrder(root.left);
	}

	public TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;
		inOrder(root);
		return root;
	}
}
