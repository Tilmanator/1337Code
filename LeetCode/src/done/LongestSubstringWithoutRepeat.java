package done;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		char[] str = s.toCharArray();

		// Keeps track of which characters are used in the current substring
		// Could use a char array but idk if it's all lowercase
		HashMap<Character, Integer> map = new HashMap<>();

		map.put(str[0], 1);
		int start = 0;

		int length = 1;
		for (int i = 1; i < str.length; ++i) {
			if (map.containsKey(str[i])) {
				// Move start up and exclude the chars we pass over from the
				// current substring
				while (start < i && str[start] != str[i]) {
					map.remove(str[start]);
					start++;
				}
				// If we started on this character OR the two characters are
				// beside each other (bb), move up start
				while (str[start] == str[i] && start < i)
					start++;

			} else
				// Simple case
				map.put(str[i], 1);
			// Check if this one is optimal
			length = Math.max(length, i - start + 1);
		}

		return length;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pw"));

	}

}
