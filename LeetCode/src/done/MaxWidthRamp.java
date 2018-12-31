package done;

import java.util.Stack;

public class MaxWidthRamp {
	public int maxWidthRamp(int[] A) {
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < A.length; ++i) {
			if (s.isEmpty() || A[i] < A[s.peek()])
				s.push(i);
		}

		int best = 0;
		for (int i = A.length - 1; i >= 0; --i) {
			while (!s.isEmpty() && A[i] >= A[s.peek()]) {
				best = Math.max(best, i - s.pop());
			}
		}

		return best;
	}
}
