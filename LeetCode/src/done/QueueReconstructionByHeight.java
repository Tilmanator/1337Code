package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		// Tall people don't care about short people
		// So first sort by height desc
		// For equal height, sort by tall people in front of them asc
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

		// Now we can just file people into their designated spots, knowing that
		// there cannot be an index out of bounds exception, thanks to our
		// sorting by height, then # of people in front (people in front have
		// been added)
		List<int[]> correct = new ArrayList<>();
		for (int[] person : people) {
			correct.add(person[1], person);
		}

		// Typing
		int[][] ret = new int[correct.size()][2];
		return correct.toArray(ret);
	}

}
