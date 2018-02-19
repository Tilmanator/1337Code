
public class Zigzag {

	public static String convert(String s, int numRows) {
		String ret = "";
		if (numRows == 1) {
			return s;
		}

		for (int row = 0; row < numRows; ++row) {
			boolean down = true;
			// Lower or upper half of rows decides which jump we take
			int val = (int) Math.min(row, numRows - 1 - row);

			if (val == 0) {
				for (int j = row; j < s.length(); j += 2 * numRows - 2) {
					ret += s.charAt(j);
				}
			} else {
				int index = row;

				// Add all the characters on the current row
				// It essentially "jumps" to the next character in line by
				// following the pattern
				// The pattern at a certain point can go up or down which needs
				// to be tracked
				while (index < s.length()) {
					ret += s.charAt(index);
					if (down) {
						int jump = 2 * (numRows - row) - 2;
						index += jump;
						down = !down;

					} else {
						int jump = 2 * row;
						index += jump;
						down = !down;
					}
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}

}
