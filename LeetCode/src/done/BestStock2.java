package done;

public class BestStock2 {
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int maxp = 0;
		int currMin = prices[0];
		for (int i = 1; i < prices.length; ++i) {
			// Make sure we end on a low note (or the end of array)
			while (i < prices.length && prices[i] > prices[i - 1])
				++i;
			
			// sell it before the drop!!!
			maxp += prices[i - 1] - currMin;
			
			// We want to reset since we just sold something
			if (i < prices.length)
				currMin = prices[i];
		}
		return maxp;
	}
}
