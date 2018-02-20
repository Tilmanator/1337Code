package done;

public class BestStock {
	/*
	 * Compare the price at index i to the minimum seen so far and try to update
	 * the max price
	 */
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int min = prices[0];
		int maxp = 0;
		for (int i = 1; i < prices.length; ++i) {
			if (prices[i] < min) {
				min = prices[i];
				continue;
			}
			maxp = Math.max(maxp, prices[i] - min);
		}
		return maxp;
	}
}
