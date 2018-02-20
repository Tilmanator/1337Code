package done;

public class Zigzag {

	public static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		// Length from one "peak" to the next visually
		// For a given row, all values in it are the same mod repeatLength
		int repeatLength = 2 * numRows - 2;
		String ret = "";

		// Go through all rows, use symmetry to find all letters in a row
		for (int row = 0; row < numRows; ++row) {
			int index = 0;
			while (index < s.length()) {
				// This checks both the 'up' and 'down' portion of each zigzag
				if (index % repeatLength == row
						|| ((index / repeatLength + 1) * repeatLength - index) % repeatLength == row)
					ret += s.charAt(index);
				++index;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}

}
