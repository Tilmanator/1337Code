package done;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();

		if (sum % 2 == 1)
			return false;

		// Should change to bitset?
		boolean[] dp = new boolean[sum / 2 + 1];
		dp[0] = true;

		for (int i : nums) {
			for (int j = dp.length - 1; j >= 0; --j) {
				if (dp[j] && j + i <= sum / 2) {
					dp[i + j] = true;
					if (i + j == sum / 2)
						return true;
				}

			}
		}

		return false;
	}

}
