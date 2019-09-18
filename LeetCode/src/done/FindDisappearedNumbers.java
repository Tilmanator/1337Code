package done;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return ret;

		// Since we know the range of the numbers we can
		// 'mark' them by setting their respective index negative
		for (int i = 0; i < nums.length; ++i) {
			int next = nums[i];
			if (next < 0) {
				next = -next;
			}
			nums[next - 1] = -Math.abs(nums[next - 1]);
		}

		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] > 0) {
				ret.add(i + 1);
			}
		}
		return ret;
	}
}
