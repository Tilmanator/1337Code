package done;

public class MaximumBinaryTree {

	// assume lo < hi
	public static int maxIndex(int[] nums, int lo, int hi) {
		if (lo >= hi)
			return -1;
		int max = Integer.MIN_VALUE;
		int idx = lo;
		for (int i = lo; i < hi; ++i) {
			if (nums[i] > max) {
				max = nums[i];
				idx = i;
			}
		}
		return idx;
	}

	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		return help(nums, 0, nums.length);
	}

	// Simply construct the max trees recursively on each side
	
	public static TreeNode help(int[] nums, int min, int max) {
		if (min >= max)
			return null;
		int m = maxIndex(nums, min, max);
		TreeNode root = new TreeNode(nums[m]);
		root.left = help(nums, min, m);
		root.right = help(nums, m + 1, max);
		return root;
	}

	public static void main(String[] args) {
		int[] n = { 3, 2, 1, 6, 0, 5 };
		TreeNode r = constructMaximumBinaryTree(n);
		while (r != null) {
			System.out.println(r.val);
			if (r.left != null)
				r = r.left;
			else
				r = r.right;
		}
	}

}
