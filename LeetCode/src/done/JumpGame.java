package done;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums.length == 0)
			return true;
		// Keep track of all possible places you can reach
		boolean[] reach = new boolean[nums.length];
		reach[0] = true;
		for (int i = 0; i < nums.length; ++i) {
			if (reach[i]) {
				// Once you can reach the end, quit
				if (nums[i] + i + 1 >= nums.length)
					return true;
				// Fill in where you can reach, but once you find a spot you can
				// reach already you know all the ones lower than it can be
				// reached as well, so quit early
				for (int j = nums[i] + i; !reach[j] && j > i; --j)
					reach[j] = true;
			}
		}
		// Unable to reach end
		return false;
	}
}
