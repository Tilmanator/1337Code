package done;

public class UniquePaths {

	public int uniquePaths(int m, int n) {
		// Store the number of possible ways at each point, add row of zeroes as
		// utility
		int[][] dp = new int[m + 1][n + 1];

		// (1,1) will take this dummy value to initialize the starting pos
		dp[0][1] = 1;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				// #[i,j] = Ways from the spot above + left
				dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
			}
		}
		return dp[m][n];
	}
}
