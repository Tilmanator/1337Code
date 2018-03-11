package done;
import java.util.Stack;

public class LongestValidParentheses {

	public static int longestValidParentheses(String s) {
		Stack<Integer> open = new Stack<>();
		char[] c = s.toCharArray();

		int max = 0;

		for (int i = 0; i < c.length; ++i) {
			// Keep track of the indexes of open brackets
			if (c[i] == '(') {
				open.push(i);
			} // If we can close an open one do so 
			else if (open.size() > 0) {
				int curr = open.pop();
				max = max > i - curr + 1 ? max : i - curr + 1;

				// Special case: ()()
				if (i + 1 < c.length && c[i + 1] == '(') {
					++i;
					open.push(curr);
				}
			}
		}
		return max;

	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()"));
	}
}
