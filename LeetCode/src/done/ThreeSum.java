package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	// Take advantage of the fact that given array is sorted
	public static List<List<Integer>> modTwoSum(int[] nums, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		int low = 0;
		int high = nums.length-1;
		
		// Since sorted, simply move numbers inwards until we reach the target or exit condition
		while(low < high){
			// target reached, now skip any duplicates and keep looking
			if(nums[low] + nums[high] == target){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(nums[low]);
				tmp.add(nums[high]);
				ret.add(tmp);
				while(low < high && nums[low] == nums[low + 1])
					++low;
				while(low < high && nums[high] == nums[high-1])
					--high;
				++low;
				--high;
			}
			// below target so increase lower pointer, same concept for higher pointer
			else if(nums[low] + nums[high] < target){
				++low;
			}
			else{
				--high;
			}
		}
		return ret;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3)
			return new ArrayList<>();
		List<List<Integer>> ret = new ArrayList<>();
		// Sorted now we can optimize two sum and skip duplicates easily
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; ++i) {
			// Skip duplicates (they can still occur in solution because we start with the first one)
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int [] n = new int[nums.length-1-i];
				for(int j=i+1; j< nums.length;++j){
					n[j-(i+1)] = nums[j];
				}
				// Perform twoSum with the target being negative current number
				List<List<Integer>> tmp = modTwoSum(n,-nums[i]);
				for(List<Integer> a: tmp){
					a.add(nums[i]);
					ret.add(a);
				}
			}
		}
		return ret;

	}

	public static void main(String[] args) {
		//int [] n = {1,2,-3,4,5,6,-7,8,9,10};
		//int [] q = {-2,-2,-2,-2,-2,-2,2,2,4,-1,-1,0,0,1,1};
		int[] p = {-1,0,1,2,-1,-4};
		List<List<Integer>> ret = threeSum(p);
		System.out.println(ret.size());
		for (List<Integer> i : ret) {
			System.out.println(i.get(0) + " " + i.get(1) + " " + i.get(2));
		}
	}

}