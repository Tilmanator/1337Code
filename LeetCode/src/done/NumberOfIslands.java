package done;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int islands = 0;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (grid[i][j] == '1') {
					++islands;
					remove(i, j, grid);
				}
			}
		}
		return islands;
	}

	public void remove(int i, int j, char[][] grid) {
		// Stop when out of bounds
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
			return;

		// Make it known this place has been visited
		grid[i][j] = '0';
		remove(i - 1, j, grid);
		remove(i, j - 1, grid);
		remove(i + 1, j, grid);
		remove(i, j + 1, grid);
	}
}
