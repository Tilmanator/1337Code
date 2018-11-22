package done;

import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (wordDict.size() == 0)
			return false;

		// Store whether it's possible to reach an index i
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 0; i < s.length(); ++i) {
			if (dp[i]) {
				for (String str : wordDict) {
					if (str.length() + i <= s.length()) {
						if (s.substring(i, i + str.length()).equals(str)) {
							dp[i + str.length()] = true;
						}
					}
				}
			}
		}

		return dp[s.length()];
	}
}
