package done;

import java.util.Stack;

public class ValidateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		int pushIndex = 0, popIndex = 0;

		// Can't pop unless we've pushed
		if (pushed.length == 0)
			return popped.length == 0;

		Stack<Integer> s = new Stack<>();
		// We know there's somethig to push
		s.push(pushed[pushIndex++]);

		//
		while (pushIndex < pushed.length && popIndex < popped.length) {
			if (s.size() > 0) {
				int top = s.peek();
				// Pop if we can
				if (popped[popIndex] == top) {
					s.pop();
					++popIndex;
					continue;
				}
			}
			// Push if we haven't popped
			s.push(pushed[pushIndex++]);
		}

		// Ensure we've popped in order
		while (s.size() > 0) {
			if (s.pop() != popped[popIndex++])
				return false;
		}

		return true;

	}
}
