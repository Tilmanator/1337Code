package done;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
	public String getHint(String secret, String guess) {

		// Store the count of leftover characters in the secret string
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		// Rebuild guess string based on how many bulls were found
		StringBuilder s = new StringBuilder("");

		int bulls = 0, cows = 0;
		for (int i = 0; i < secret.length(); ++i) {
			char c = secret.charAt(i);
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
			if (i > guess.length())
				continue;

			if (c == guess.charAt(i)) {
				++bulls;
				map.put(c, map.get(c) - 1);
			} else {
				s.append(guess.charAt(i));
			}
		}

		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (map.containsKey(c) && map.get(c) > 0) {
				map.put(c, map.get(c) - 1);
				++cows;
			}
		}

		return bulls + "A" + cows + "B";
	}
}
