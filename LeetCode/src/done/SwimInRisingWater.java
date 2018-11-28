package done;

import java.util.PriorityQueue;
import java.util.Queue;

public class SwimInRisingWater {
	public int swimInWater(int[][] grid) {
		int n = grid.length;
		if (n < 2)
			return 0;
		boolean[][] vis = new boolean[n][n];

		Queue<Spot> q = new PriorityQueue<>((a, b) -> a.height - b.height);

		q.add(new Spot(grid[0][0], 0, 0));

		int min = 0;
		while (!q.isEmpty()) {
			Spot curr = q.poll();
			min = Math.max(min, curr.height);
			if (curr.x == n - 1 && curr.y == n - 1) {
				return min;
			}

			vis[curr.x][curr.y] = true;

			if (curr.x > 0 && !vis[curr.x - 1][curr.y])
				q.offer(new Spot(grid[curr.x - 1][curr.y], curr.x - 1, curr.y));
			if (curr.y > 0 && !vis[curr.x][curr.y - 1])
				q.offer(new Spot(grid[curr.x][curr.y - 1], curr.x, curr.y - 1));
			if (curr.x < n - 1 && !vis[curr.x + 1][curr.y])
				q.offer(new Spot(grid[curr.x + 1][curr.y], curr.x + 1, curr.y));
			if (curr.y < n - 1 && !vis[curr.x][curr.y + 1])
				q.offer(new Spot(grid[curr.x][curr.y + 1], curr.x, curr.y + 1));
		}

		return min;
	}
}

class Spot {
	int height, x, y;

	Spot(int a, int b, int c) {
		height = a;
		x = b;
		y = c;
	}
}
