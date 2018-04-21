package done;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0)
			return 0;
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (j == 0 && i == 0)
					continue;
				if (i == 0) {
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
				} else {
					dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
