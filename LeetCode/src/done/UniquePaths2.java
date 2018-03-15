package done;

public class UniquePaths2 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// See Unique Paths
		// The only difference is that we only update non-obstacle spots
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
		dp[0][1] = 1;

		for (int i = 0; i < obstacleGrid.length; ++i) {
			for (int j = 0; j < obstacleGrid[0].length; ++j) {
				// This works because obstacle spots will remain at 0
				if (obstacleGrid[i][j] == 0)
					dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
