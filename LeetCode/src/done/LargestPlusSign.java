package done;

public class LargestPlusSign {

	public static int orderOfLargestPlusSign(int N, int[][] mines) {
		// utility array so it is easier to fill the other ones in DP step
		int[][] grid = new int[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				grid[i][j] = 1;
			}
		}
		for (int i = 0; i < mines.length; ++i) {
			grid[mines[i][0]][mines[i][1]] = 0;
		}

		// Find longest streaks without mines in each direction
		// The largest plus sign will center at the point where the lowest of
		// all streaks is at a maximum (since plus sign is limited by the
		// direction with the fewest continuous non-mine spots
		int[][] left = new int[N][N];
		int[][] right = new int[N][N];
		int[][] up = new int[N][N];
		int[][] down = new int[N][N];

		// Down and left -> right
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				// Take advantage of the fact that array is 0 initialized
				if (grid[i][j] == 0)
					continue;
				down[i][j] = i - 1 >= 0 ? down[i - 1][j] + 1 : 1;
				left[i][j] = j - 1 >= 0 ? left[i][j - 1] + 1 : 1;
			}
		}

		// Up and right -> left
		for (int i = N - 1; i >= 0; --i) {
			for (int j = N - 1; j >= 0; --j) {
				// Take advantage of the fact that array is 0 initialized
				if (grid[i][j] == 0)
					continue;
				up[i][j] = i + 1 < N ? up[i + 1][j] + 1 : 1;
				right[i][j] = j + 1 < N ? right[i][j + 1] + 1 : 1;
			}
		}

		int x = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				int curr = Math.min(left[i][j], Math.min(right[i][j], Math.min(up[i][j], down[i][j])));
				if (curr > x)
					x = curr;
			}
		}

		return x;

	}

	public static void main(String[] args) {
		int[][] mines = { { 3, 0 }, { 3, 3 } };

		System.out.println(orderOfLargestPlusSign(5, mines));
		// TODO Auto-generated method stub

	}

}
