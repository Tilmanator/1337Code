package done;

import java.util.Arrays;

public class OnlineElection {
	class TopVotedCandidate {

		int[] time;
		int[] winners;

		public TopVotedCandidate(int[] persons, int[] times) {

			// Bad
			if (persons.length == 0) {
				time = null;
				winners = null;
				return;
			}

			int[] votes = new int[persons.length];
			winners = new int[persons.length];
			time = times;

			// Keep track of current winner and votes
			int max = 0;
			int oldWinner = 0;

			for (int i = 0; i < persons.length; ++i) {
				int currVotes = ++votes[persons[i]];
				time[i] = times[i];

				if (currVotes >= max) {
					max = currVotes;
					oldWinner = persons[i];
				}
				winners[i] = oldWinner;
			}
		}

		// Log(n) retrieval by searching through the times, we know the winner
		// for each of the time indices
		public int q(int t) {
			int i = Arrays.binarySearch(time, t);

			// If it asks before the first vote was cast
			if (i == -1)
				return -1;
			return i < 0 ? winners[-i - 2] : winners[i];
		}
	}

}
