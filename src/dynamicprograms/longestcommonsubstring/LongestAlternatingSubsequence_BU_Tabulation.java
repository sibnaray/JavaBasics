package dynamicprograms.longestcommonsubstring;

import java.util.Arrays;

public class LongestAlternatingSubsequence_BU_Tabulation {
    public static void main(String[] args) {
        LongestAlternatingSubsequence_BU_Tabulation las = new LongestAlternatingSubsequence_BU_Tabulation();
        int[] nums = {1,2,3,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLength(nums));
    }

    int findLASLength(int[] nums){
        int[][] dp = new int[2][nums.length];
        Arrays.fill(dp[0],1);
        Arrays.fill(dp[1],1);

        int maxLength = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    // if nums[i] is BIGGER than nums[j] then we will consider the LAS ending at 'j' where the
                    // last two elements were in DESCENDING order
                    dp[0][i] = Math.max(dp[0][i], 1+dp[1][j]);
                    maxLength = Math.max(maxLength, dp[0][i]);
                }else{
                    // if nums[i] is SMALLER than nums[j] then we will consider the LAS ending at 'j' where the
                    // last two elements were in ASCENDING order
                    dp[1][i] = Math.max(dp[1][i], 1+dp[0][j]);
                    maxLength = Math.max(maxLength, dp[1][i]);
                }
            }
        }
        return maxLength;
    }
}
