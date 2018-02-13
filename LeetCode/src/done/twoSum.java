package done;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
	
	/*
	 * Store indexes of the two nums that sum up to target.
	 * Hash target - current number, that way we can break out of for loop
	 * once a numbers hash exists
	 */
	 public static int[] twoSumm(int[] nums, int target) {
		 	int [] ret = new int[2];
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i=0;i< nums.length; i++){
	        	if(map.containsKey(nums[i])){
	        		ret[1]=i;
	        		ret[0]=map.get(nums[i]);
	        	}
	        	map.put((target-nums[i]), i);
	        }
	        return ret;
	  }
	 
	 
	 public static void main(String [] args){
		 int [] test = {2,7,11,15};
		 int tar = 9;
		 int [] p = twoSumm(test,tar);
		 for(int o:p)
			 System.out.println(o);
	 }
}
