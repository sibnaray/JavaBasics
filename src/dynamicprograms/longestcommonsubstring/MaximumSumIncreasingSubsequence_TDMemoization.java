package dynamicprograms.longestcommonsubstring;

import java.util.HashMap;
import java.util.HashSet;

//The three changing values for our recursive function are the current index, the previous index, and the sum.
// An efficient way of storing the results of the subproblems could be a hash-table whose key
// would be a string (currentIndex + “|” + previousIndex + “|” + sum).
public class MaximumSumIncreasingSubsequence_TDMemoization {

    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence_TDMemoization msis = new MaximumSumIncreasingSubsequence_TDMemoization();
        int[] nums = {4,1,2,6,10,1,12};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(msis.findMSIS(nums));
    }

    int findMSIS(int[] nums){
        HashMap<String, Integer> dp  = new HashMap<>();
        return findMSIS_TD(dp,nums,0,-1,0);
    }

    int findMSIS_TD(HashMap<String, Integer> dp, int[] nums, int curIndex, int prevIndex, int sum){
        if(nums.length == curIndex)
            return sum;

        String subProbKey = curIndex+"|"+prevIndex+"|"+sum;
        if(!dp.containsKey(subProbKey)){
            int s1=sum;
            if(prevIndex==-1 || nums[curIndex] > nums[prevIndex]){
                s1 = findMSIS_TD(dp,nums, curIndex+1, curIndex, sum+nums[curIndex]);
            }

            int s2 = findMSIS_TD(dp,nums, curIndex+1, prevIndex, sum);
            dp.put(subProbKey,Math.max(s1,s2));
        }
        return dp.get(subProbKey);
    }
}
