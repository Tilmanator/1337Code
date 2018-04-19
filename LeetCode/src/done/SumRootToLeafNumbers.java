package done;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {

	int sum = 0;

	public int sumNumbers(TreeNode root) {
		List<Integer> p = new ArrayList<>();
		help(p, root);
		return sum;
	}

	// Only add once at a leaf node
	public void help(List<Integer> list, TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			sum += add(list);
			list.remove(list.size() - 1);
			return;
		}

		// Go through nodes below first
		list.add(root.val);
		help(list, root.right);
		help(list, root.left);
		list.remove(list.size() - 1);

	}

	// Parse the list into a number
	public int add(List<Integer> list) {
		int sum = 0;
		for (int i = list.size() - 1; i >= 0; --i) {
			sum += list.get(i) * Math.pow(10, list.size() - 1 - i);
		}
		return sum;
	}
}
