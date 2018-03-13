package done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		if (root == null)
			return new LinkedList<Integer>();
		Queue<TreeNode> bfs = new LinkedList<>();
		bfs.add(root);

		List<Integer> ret = new ArrayList<Integer>();

		while (!bfs.isEmpty()) {
			int l = bfs.size();
			for (int i = 0; i < l; ++i) {
				TreeNode curr = bfs.poll();
				if (curr.left != null)
					bfs.add(curr.left);
				if (curr.right != null)
					bfs.add(curr.right);
				if (i == l - 1)
					ret.add(curr.val);
			}
		}
		return ret;
	}
}
