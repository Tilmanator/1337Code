package done;

public class HouseRobber {

	// Use O(n) space but makes solution nice
	public static int rob(int[] nums) {
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

	public static void main(String[] args) {
		int[] nums = { 2, 1, 1, 2 };
		System.out.println(rob(nums));
	}
}
