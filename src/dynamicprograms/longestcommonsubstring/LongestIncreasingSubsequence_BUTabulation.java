package dynamicprograms.longestcommonsubstring;
//Given a number sequence, find the length of its Longest Increasing Subsequence (LIS).
// In an increasing subsequence, all the elements are in increasing order (from lowest to highest).

//Input: {4,2,3,6,10,1,12}
//Output: 5
//Explanation: The LIS is {2,3,6,10,12}.

//Input: {-4,10,3,7,15}
//Output: 4
//Explanation: The LIS is {-4,3,7,15}.

//If the number at the current index is bigger than the number at the previous index,
// we increment the count for LIS up to the current index.

//But if there is a bigger LIS without including the number at the current index, we take that.

//If ‘i’ represents the ‘currentIndex’ and ‘j’ represents the ‘previousIndex’, our recursive formula would look like:
//if num[i] > num[j] => dp[i] = dp[j] + 1 if there is no bigger LIS for 'i'

import java.util.Arrays;

public class LongestIncreasingSubsequence_BUTabulation {
    public static void main(String[] args) {
        LongestIncreasingSubsequence_BUTabulation lis = new LongestIncreasingSubsequence_BUTabulation();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lis.findLISLength(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(lis.findLISLength(nums));
    }

    int findLISLength(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i=1; i<nums.length; i++){
            for(int j = 0 ; j<i; j++){
                if(nums[i] > nums[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }
        return dp[nums.length-1];
    }
}
