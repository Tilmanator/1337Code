package done;

public class FindPeak {
	// If the current element is larger than the next one, it is a local maximum
	// This is true because the first element is larger than the one before it
	// (-1st element = -inf)
	public int findPeakElement(int[] nums) {
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] > nums[i + 1])
				return i;
		}
		return nums.length - 1;
	}
}
