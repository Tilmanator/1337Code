package done;

public class OutOfBoudaryPaths {
	int ret = 0;

	public int findPaths(int m, int n, int N, int i, int j) {
		int[][] dp = new int[m][n];
		// up, down, dodge and duck
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int ret = 0;
			
		// starting point
		dp[i][j] = 1;

		for (int step = 0; step < N; ++step) {
			// update at each step
			int[][] now = new int[m][n];
			for (int row = 0; row < m; ++row) {
				for (int col = 0; col < n; ++col) {
					for (int[] d : dirs) {
						int c = col + d[0];
						int r = row + d[1];
						if (c < 0 || c >= n || r < 0 || r >= m) {
							ret += dp[row][col];
							ret = ret % 1000000007;
						} else {
							now[r][c] += dp[row][col];
							now[r][c] = now[r][c] % 1000000007;
						}
					}
				}
			}
			dp = now;
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
