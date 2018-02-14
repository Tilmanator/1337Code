package done;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class threeSum {

	public  static Set<ArrayList<Integer>> modTwoSum(int[] nums, int target) {
		Set<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i< nums.length; i++){
        	if(map.containsKey(nums[i])){
        		ArrayList<Integer>temp = new ArrayList<Integer>(2);
        		temp.add(map.get(nums[i]));
        		temp.add(nums[i]);
        		ret.add(temp);
        		
        	}
        	map.put((target-nums[i]), nums[i]);
        }
        return ret;
  }
	
	public static Set<ArrayList<Integer>> threeSumm(int [] nums){
		Set<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
		Arrays.sort(nums);
		for(int i =0;i<nums.length;++i){
			int [] n = new int[nums.length-i];
			for(int j=i+1; j<nums.length;++j){
				n[j-(i+1)] = nums[j];
			}
			Set<ArrayList<Integer>> r = modTwoSum(n,-nums[i]);
			for(ArrayList<Integer> p: r){
				@SuppressWarnings("unchecked")
				ArrayList<Integer> tmp = (ArrayList<Integer>)p.clone();
				tmp.add(nums[i]);
				tmp.sort(null);
				ret.add(tmp);
			}
		}
		return ret;
		
	}
	
	public static void main(String[] args) {
		//int [] n = {1,2,-3,4,5,6,-7,8,9,10};
		int [] p = {-1,0,1,2,-1,-4};
		//int tar = 10;
		Set<ArrayList<Integer>> ret = threeSumm(p);
		for(ArrayList<Integer> i : ret){
			System.out.println(i.get(0)+" "+i.get(1)+" "+i.get(2));
		}
	}

}