import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortCharsByFreq {

	// Sort by values descending
	static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> customEntriesSortedByValues(Map<K, V> map) {
		SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
				int res = e1.getValue().compareTo(e2.getValue());
				return res != 0 ? -res : -1;
			}
		});
		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}

	public static String frequencySort(String s) {
		// Keep track of number of occurrences per char
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			m.put(c, 1 + (m.containsKey(c) ? m.get(c) : 0));
		}
		String ret = "";

		// Sort properly
		SortedSet<Map.Entry<Character, Integer>> q = customEntriesSortedByValues(m);
		Iterator<Entry<Character, Integer>> it = q.iterator();

		// Make the string based on sorted values
		while (it.hasNext()) {
			Entry<Character, Integer> e = it.next();
			for (int i = 0; i < e.getValue(); ++i) {
				ret += e.getKey();
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("poasdjjeeavvv"));

	}

}
