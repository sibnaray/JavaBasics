package dynamicprograms.longestcommonsubstring;

import java.util.HashMap;

public class BitonicSubsequence_TD_Memoization {
    public static void main(String[] args) {
        BitonicSubsequence_TD_Memoization lbs = new BitonicSubsequence_TD_Memoization();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lbs.findLBSLength(nums));
        nums = new int[]{4,2,5,9,7,6,10,3,1};
        System.out.println(lbs.findLBSLength(nums));
    }

    int findLBSLength(int[] nums){
        int maxLength=0;
        HashMap<String,Integer> dpMqp = new HashMap<>();
        HashMap<String,Integer> dpMap_Rev = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c1 = findLongestIncreasingSeq(dpMqp, nums, i,-1);
            int c2 = findLongestDecreasingSeq(dpMap_Rev, nums, i,-1);
            maxLength = Math.max(maxLength,c1+c2-1);
        }
        return maxLength;
    }

    int findLongestIncreasingSeq(HashMap<String,Integer> dpMqp, int[] nums, int currIndex, int prevIndex){
        if(currIndex==nums.length)
            return 0;

        String key = currIndex +"|" + prevIndex;
        if(!dpMqp.containsKey(key)){
            int c1=0;
            if(prevIndex == -1 || nums[currIndex] < nums[prevIndex])
                c1 = 1 + findLongestIncreasingSeq(dpMqp,nums,currIndex+1, currIndex);

            int c2 = findLongestIncreasingSeq(dpMqp,nums,currIndex+1, prevIndex);
            dpMqp.put(key,Math.max(c1,c2));
        }
        return dpMqp.get(key);
    }

    int findLongestDecreasingSeq(HashMap<String,Integer> dpMqp_Rev, int[] nums, int currIndex, int prevIndex){
        if(currIndex<0)
            return 0;

        String key = currIndex+"|"+prevIndex;
        if(!dpMqp_Rev.containsKey(key)){
            int c1=0;
            if(prevIndex == -1 || nums[currIndex] < nums[prevIndex])
                c1=1 + findLongestDecreasingSeq(dpMqp_Rev,nums,currIndex-1, currIndex);

            int c2=findLongestDecreasingSeq(dpMqp_Rev,nums,currIndex-1, prevIndex);
            dpMqp_Rev.put(key,Math.max(c1,c2));
        }
        return dpMqp_Rev.get(key);
    }
}
