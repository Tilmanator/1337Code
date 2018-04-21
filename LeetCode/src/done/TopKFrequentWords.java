package done;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class TopKFrequentWords {

	static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> sorted(Map<K, V> map) {
		SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
				int res = e2.getValue().compareTo(e1.getValue());
				if (res == 0) {
					return ((String) e1.getKey()).compareTo((String) e2.getKey());
				}
				return res;

			}
		});
		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}

	public static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> ret = new LinkedList<String>();

		for (String w : words) {
			if (map.containsKey(w)) {
				map.replace(w, map.get(w) + 1);
			} else {
				map.put(w, 1);
			}
		}

		SortedSet<Map.Entry<String, Integer>> q = sorted(map);

		Iterator<Entry<String, Integer>> i = q.iterator();
		int count = 0;
		while (i.hasNext() && count < k) {
			ret.add(i.next().getKey());
			count++;
		}

		return ret;
	}

	public static void main(String[] args) {
		String[] p = { "hello", "c", "c", "c", "a", "a", "b", "d", "p" };
		System.out.println(topKFrequent(p, 2));
	}

}
