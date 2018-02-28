package done;

public class TrapRainWater {

	public static int trap(int[] height) {
		int sum = 0;

		// Water can't be trapped in first/last col so iterate through the
		// indexes where it can
		for (int i = 1; i < height.length - 1; ++i) {
			// Max heights right/left of current block
			// Note this can include the current block since it could be tallest
			int left = 0, right = 0;

			for (int j = i; j >= 0; --j) {
				left = Math.max(left, height[j]);
			}
			for (int j = i; j < height.length; ++j) {
				right = Math.max(right, height[j]);
			}

			// The water trapped is simply the height of the shorter enclosing
			// boundary minus height of the current block
			sum += Math.min(left, right) - height[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] num = { 5, 4, 1, 2 };
		System.out.println(trap(num));

	}

}
