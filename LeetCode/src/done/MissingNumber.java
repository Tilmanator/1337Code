package done;

public class MissingNumber {
	// XOR numbers 0 to n with values in array. Since size(array) = n-1,
	// one of the numbers will not be 'zeroed' since x^x = 0
	public int missingNumber(int[] nums) {
		// Since we do not check this as an index, start off with this value
		int check = nums.length;
		for (int i = 0; i < nums.length; ++i) {
			// XOR the index and value
			check ^= i;
			check ^= nums[i];
		}
		return check;
	}
}
