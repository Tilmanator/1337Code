package done;

public class SurroundedRegions {
	class Solution {
		public void solve(char[][] board) {
			if (board.length == 0 || board[0].length == 0)
				return;
			int[][] notSurrounded = new int[board.length][board[0].length];
			// Check for O on the edges
			for (int i = 0; i < board.length; i++) {
				recurse(board, notSurrounded, i, 0);
				recurse(board, notSurrounded, i, board[0].length - 1);
			}
			for (int i = 0; i < board[0].length; ++i) {
				recurse(board, notSurrounded, board.length - 1, i);
				recurse(board, notSurrounded, 0, i);
			}

			// Swap the ones that are surrounded
			for (int i = 0; i < notSurrounded.length; ++i) {
				for (int j = 0; j < notSurrounded[0].length; ++j) {
					if (notSurrounded[i][j] == 0 && board[i][j] == 'O')
						board[i][j] = 'X';
				}
			}
		}

		public void recurse(char[][] board, int[][] swap, int x, int y) {
			if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
				return;
			if (board[x][y] == 'O' && swap[x][y] == 0) {
				swap[x][y] = 1;
				recurse(board, swap, x + 1, y);
				recurse(board, swap, x - 1, y);
				recurse(board, swap, x, y + 1);
				recurse(board, swap, x, y - 1);
			}
		}
	}
}
