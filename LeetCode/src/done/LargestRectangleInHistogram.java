package done;
import java.util.Stack;

public class LargestRectangleInHistogram {

	public static int largestRectangleArea(int[] nums) {
		if (nums.length == 0)
			return 0;

		// Keep a stack of streaks and the heights at which they were achieved
		Stack<Pair> s = new Stack<Pair>();
		int max = nums[0];
		s.push(new Pair(1, nums[0]));

		for (int i = 1; i < nums.length; ++i) {
			// Just add to the current count
			if (nums[i] == s.peek().height) {
				Pair p = s.peek();
				p.streakLength++;
				max = p.height * p.streakLength > max ? p.height * p.streakLength : max;

			}
			// Add a new pair
			else if (nums[i] > s.peek().height) {
				if (nums[i] > max)
					max = nums[i];
				s.push(new Pair(1, nums[i]));
			} else {
				// Pop while you can, keep count so that you can add it back
				int popped = 0;
				while (nums[i] < s.peek().height) {
					Pair p = s.pop();
					Pair next = null;
					// If the next number is unique, don't append to the next
					// lower height's streak
					if (!s.isEmpty() && nums[i] < s.peek().height) {
						next = s.pop();
					} else {
						next = new Pair(1, nums[i]);
					}
					next.streakLength += p.streakLength;

					// update max
					max = next.height * next.streakLength > max ? next.height * next.streakLength : max;

					// Add the next (a.k.a current) element
					s.push(next);
					popped++;
				}

				// If the number is larger than the current one on the stack,
				// add all the stereaks
				if (nums[i] > s.peek().height) {
					s.push(new Pair(1 + popped, nums[i]));
					max = max > nums[i] ? max : nums[i];
				}
			}

			// System.out.println(s.peek().streakLength + " " +
			// s.peek().height);

		}

		// At the end, check if using a lower height could give better results
		int curr = 0;
		if (!s.isEmpty()) {
			curr = s.pop().streakLength;
		}
		while (!s.isEmpty()) {
			Pair p = s.pop();
			// Since it is lower height, the previous larger height could have
			// been included
			p.streakLength += curr;

			curr = p.streakLength;

			max = p.height * p.streakLength > max ? p.height * p.streakLength : max;
		}

		return max;
	}

	public static void main(String[] args) {
		int[] n = {1,0};
		System.out.println(largestRectangleArea(n));
	}

}

class Pair {
	int streakLength;
	int height;

	Pair(int x, int y) {
		streakLength = x;
		height = y;
	}
}
