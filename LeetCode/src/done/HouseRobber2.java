package done;

public class HouseRobber2 {
	public int rob(int[] nums) {
		if (nums.length < 2)
			return nums.length == 0 ? 0 : nums[0];
		// Can't rob first and last house, so check which is better
		int[] startHouse = new int[nums.length - 1];
		int[] endHouse = new int[nums.length - 1];
		for (int i = 0; i < nums.length - 1; ++i)
			startHouse[i] = nums[i];
		for (int i = 1; i < nums.length; ++i)
			endHouse[i - 1] = nums[i];

		return Math.max(robSimple(endHouse), robSimple(startHouse));
	}

	public static int robSimple(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] max = new int[nums.length];
		max[0] = nums[0];
		for (int i = 1; i < max.length; ++i) {
			// Check corner case
			int val = i - 2 >= 0 ? max[i - 2] : 0;
			// Check whether it is better to rob this house or the previous
			// house
			max[i] = Math.max(max[i - 1], nums[i] + val);
		}

		return max[max.length - 1];
	}
}
