package done;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs[0].length() == 0)
			return "";
		StringBuilder pre = new StringBuilder("");
		int index = 0;

		// Check with the first string
		while (index < strs[0].length()) {
			char curr = strs[0].charAt(index);
			// Check all the other strings
			for (int i = 1; i < strs.length; ++i) {
				if (index >= strs[i].length() || strs[i].charAt(index) != curr)
					return pre.toString();
			}
			pre.append(curr);
			index++;
		}

		return pre.toString();
	}
}
