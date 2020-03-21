package dynamicprograms.longestcommonsubstring;

import java.util.HashMap;

public class LongestAlternatingSubsequence_TD_Memoization {
    public static void main(String[] args) {
        LongestAlternatingSubsequence_TD_Memoization las = new LongestAlternatingSubsequence_TD_Memoization();
        int[] nums = {1,2,3,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLength(nums));
    }

    int findLASLength(int[] nums){
        HashMap<String, Integer> dpMap = new HashMap<>();
        return Math.max(findLASLength_TD(dpMap,nums,-1,0,true),
                findLASLength_TD(dpMap,nums, -1,0,false));
    }

    int findLASLength_TD(HashMap<String, Integer> dpMap, int[] nums, int prevIndex, int curIndex, boolean isAsc){
        if(curIndex == nums.length)
            return 0;
        String key = prevIndex+"|"+curIndex+"|"+isAsc;
        if(!dpMap.containsKey(key)){
            int c1=0;
            //if isAsc is true then previous number is less than current number
            if(isAsc){
                if(prevIndex == -1 || nums[prevIndex] < nums[curIndex])
                    c1 = 1 + findLASLength_TD(dpMap, nums,curIndex, curIndex+1, !isAsc);
            }else{
                //if isAsc is false then previous number is greater than current number
                if(prevIndex == -1 || nums[prevIndex] > nums[curIndex])
                    c1 = 1 + findLASLength_TD(dpMap, nums,curIndex, curIndex+1, !isAsc);
            }
            int c2 = findLASLength_TD(dpMap,nums,prevIndex,curIndex+1,isAsc);
            dpMap.put(key,Math.max(c1,c2));
        }
        return dpMap.get(key);
    }
}
