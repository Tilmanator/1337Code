package done;

public class TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries.length == 0)
			return 0;
		int total = duration;
		// Add duration, subtract if intervals overlap
		for (int i = 1; i < timeSeries.length; ++i) {
			total += duration;
			total -= Math.max(0, timeSeries[i - 1] - timeSeries[i] + duration);
		}
		return total;
	}
}
