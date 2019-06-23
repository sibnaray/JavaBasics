import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//Given nums = [2, 7, 11, 15], target = 9,
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].
public class TwoSums {
    public static void main(String args[]){
        int[] input = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(input,target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tempMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(tempMap.containsKey(nums[i])){
                return new int[]{tempMap.get(nums[i]),i};
            }else{
                tempMap.put(target-nums[i],i);
            }
        }
        return new int[2];
    }
}
