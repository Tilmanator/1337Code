package done;

public class LongestPalindrome {

	public static int longestPalindrome(String s) {
		// Count the characters
		int[] freq = new int[52];
		for (int i = 0; i < s.length(); ++i) {
			char p = s.charAt(i);
			if (p - 'a' < 0) {
				freq[26 + (p - 'A')]++;
			} else {
				freq[p - 'a']++;
			}
		}
		int length = 0;
		int add = 0;
		for (int i : freq) {
			// We can put a character in the middle
			if (i % 2 == 1)
				add = 1;
			length += (i / 2) * 2;
		}
		if (length % 2 == 0 && add == 1)
			length += 1;
		return length;
	}

	public static void main(String[] ar) {
		System.out.println(longestPalindrome("adasdasd"));
	}
}