package done;

import java.util.HashMap;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();

		// The sum of 0 is encountered before the first element (-1th element)
		map.put(0, -1);

		// Keep track of the difference between number of 0s and 1s encountered
		int max = 0, currDiff = 0;

		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 0)
				++currDiff;
			else
				--currDiff;

			// If this sum has been encountered before, we know there is a
			// sequence of matching 0,1s
			// Simply check if it is the longest
			if (map.containsKey(currDiff)) {
				max = Math.max(max, i - map.get(currDiff));
			} else
				map.put(currDiff, i);
		}

		return max;
	}
}
