package done;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList<>();
		if (matrix.length < 1 || matrix[0].length < 1)
			return ret;
		int dir = 1; // up, right, down, left
		int l = matrix.length * matrix[0].length;
		int i = 0;

		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		int r = 0, c = 0;

		while (i < l) {
			// System.out.println(i +" "+ r +" "+c);
			++i;
			ret.add(matrix[r][c]);
			visited[r][c] = true;

			if (dir == 0) {
				if (r < 1 || visited[r - 1][c]) {
					++dir;
					++c;
				} else {
					--r;
				}
			} else if (dir == 1) {
				if (c + 1 >= matrix[0].length || visited[r][c + 1]) {
					++dir;
					++r;
				} else {
					++c;
				}
			} else if (dir == 2) {
				if (r + 1 >= matrix.length || visited[r + 1][c]) {
					++dir;
					--c;
				} else {
					++r;
				}
			} else if (dir == 3) {
				if (c < 1 || visited[r][c - 1]) {
					dir = 0;
					--r;
				} else {
					--c;
				}
			}
		}
		return ret;

	}
}
