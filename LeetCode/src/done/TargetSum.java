package done;

public class TargetSum {

	public static int findTargetSumWays(int[] nums, int S) {
		// Hard-code the max length
		int maxSum = 1000;

		if (S > maxSum || S < -maxSum)
			return 0;
		if (nums.length == 0)
			return 0;
		int[] sum = new int[2 * maxSum + 2];

		sum[maxSum + nums[0]] = 1;
		sum[maxSum - nums[0]] = 1;
		// Hard-code the fact that -0 = +0
		if (nums[0] == 0)
			sum[maxSum] = 2;

		// Add/subtract every number from all sums that have been found
		for (int i = 1; i < nums.length; ++i) {
			int[] temp = new int[2 * maxSum + 2];

			// Check if any of the possible sums have been reached
			for (int j = 0; j < sum.length; ++j) {

				// If the current sum has been reached by previous nums
				if (sum[j] > 0) {
					// We know the bounds will be in range due to problem
					// statement
					// if (j + nums[i] < temp.length)
					// if (j - nums[i] >= 0)

					temp[j - nums[i]] += sum[j];
					temp[j + nums[i]] += sum[j];
				}
			}
			sum = temp;
		}

		for (int i : sum)
			if (i > 0)
				System.out.println(i);

		return sum[1000 + S];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] n = { 1, 1, 1, 1, 1 };
		int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };

		System.out.println(findTargetSumWays(nums, 1));
	}

}
