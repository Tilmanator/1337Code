package done;

import java.util.HashSet;
import java.util.Set;

public class NrepeatedElementIn2Narray {
	public int repeatedNTimes(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int i : A) {
			if (set.contains(i))
				return i;
			set.add(i);
		}
		return -1;
	}
}
