package done;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			int n = nums[i];
			// Track the most recent index of the same character
			if (map.containsKey(n)) {
				if (i - map.get(n) <= k)
					return true;
				// Update it
				else
					map.replace(n, i);
			} else {
				map.put(n, i);
			}
		}
		return false;
	}
}