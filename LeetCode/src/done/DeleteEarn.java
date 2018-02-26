package done;
import java.util.HashMap;

public class DeleteEarn {

	// At each point simply decide whether including the current number is
	// better than excluding it
	// If the current number isn't in the array, just take the previous max
	public static int deleteAndEarn(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		HashMap<Integer, Integer> gain = new HashMap<Integer, Integer>();

		for (int i : nums) {
			if (gain.containsKey(i)) {
				gain.put(i, gain.get(i) + i);
			} else
				gain.put(i, i);
		}

		int[] dp = new int[10001];
		if (gain.containsKey(1)) {
			dp[1] = gain.get(1);
		}
		for (int i = 2; i < dp.length; ++i) {
			if (gain.containsKey(i)) {
				if (gain.get(i) + dp[i - 2] > dp[i - 1]) {
					dp[i] = dp[i - 2] + gain.get(i);
				} else {
					dp[i] = dp[i - 1];
				}
			} else {
				dp[i] = Math.max(dp[i - 1], dp[i - 2]);
			}
		}

		System.out.println(dp[1]);

		return dp[10000];
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 2 };

		System.out.println(deleteAndEarn(nums));

	}

}
