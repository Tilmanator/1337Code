package done;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon.length == 0 || dungeon[0].length == 0)
			return 0;
		int rows = dungeon.length;
		int cols = dungeon[0].length;

		// This stores the minimum health required at [i,j] to make it to bottom
		// right alive
		int[][] dp = new int[rows][cols];

		// Minimum health at bottom right
		dp[rows - 1][cols - 1] = Math.max(1 - dungeon[rows - 1][cols - 1], 1);

		// Health > 0 so health should always be 1 unless it must be higher to
		// survive
		for (int i = rows - 1; i >= 0; --i) {
			for (int j = cols - 1; j >= 0; --j) {
				if (j == cols - 1 && i == rows - 1)
					continue;
				if (i == rows - 1) {
					dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
				} else if (j == cols - 1) {
					dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
				} else {
					// Choose which way is optimal by choosing minimum health
					// path
					int up = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
					int down = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
					dp[i][j] = Math.min(up, down);
				}
			}
		}
		return dp[0][0];
	}
}
