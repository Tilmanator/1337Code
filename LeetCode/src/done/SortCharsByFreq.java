package done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class SortCharsByFreq {

	public static String frequencySort(String s) {
		// Keep track of number of occurrences per char
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			m.put(c, 1 + (m.containsKey(c) ? m.get(c) : 0));
		}

		// Initialize list of lists of characters
		// The reason is that we can just go backwards through this list as
		// we will add a character at the index = it's count
		// Traversing it backwards thus gives us chars in order of their count
		List<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>(s.length() + 1);
		for (int i = 0; i < s.length() + 1; i++)
			list.add(i, new ArrayList<Character>());

		// Append the character to the list at an index = it's count
		// This is why we need list of list:
		// Different chars can have same count
		// (otherwise we could use reversed TreeMap)
		Iterator<Entry<Character, Integer>> it = m.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Character, Integer> e = it.next();

			for (int i = 0; i < e.getValue(); ++i) {
				list.get(e.getValue()).add(e.getKey());
			}
		}

		// Stringbuilder is better performance than string
		StringBuilder ret = new StringBuilder("");
		// Start from most occurrences and work down
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i).size() > 0) {
				ArrayList<Character> temp = list.get(i);
				for (int j = 0; j < temp.size(); ++j)
					ret.append(temp.get(j));
			}
		}

		return ret.toString();
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("poasdAjjeeavvv"));

	}

}
