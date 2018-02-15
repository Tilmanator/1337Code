package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class threeSum {

	public static List<List<Integer>> modTwoSum(int[] nums, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		Set<List<Integer>> p = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			// Skip duplicates
			if (map.containsKey(nums[i])) {
				ArrayList<Integer> temp = new ArrayList<Integer>(2);
				temp.add(map.get(nums[i]));
				temp.add(nums[i]);
				p.add(temp);
			}
			map.put((target - nums[i]), nums[i]);
		}
		ret.addAll(p);
		return ret;
	}

	public static List<List<Integer>> threeSumm(int[] nums) {
		if (nums.length < 3)
			return new ArrayList<>();
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; ++i) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int[] n = new int[nums.length - i - 1];
				for (int j = i + 1; j < nums.length; ++j) {
					n[j - (i + 1)] = nums[j];
				}
				List<List<Integer>> r = modTwoSum(n, -nums[i]);
				for (List<Integer> p : r) {
					//List<Integer> tmp = (List<Integer>) ((ArrayList<Integer>) p).clone();
					p.add(nums[i]);
					p.sort(null);
					ret.add(p);
				}
			}
		}
		return ret;

	}

	public static void main(String[] args) {
		//int [] n = {1,2,-3,4,5,6,-7,8,9,10};
		int [] n = {-2,-2,-2,-2,-2,-2,2,2,4,-1,-1,0,0,1,1};
		int[] p = { 0,0,0 };
		// int tar = 10;
		List<List<Integer>> ret = threeSumm(n);
		System.out.println(ret.size());
		for (List<Integer> i : ret) {
			System.out.println(i.get(0) + " " + i.get(1) + " " + i.get(2));
		}
	}

}