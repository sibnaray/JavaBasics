package dynamicprograms.longestcommonsubstring;
//The above algorithm tells us two things:
//
//If the number at the current index is bigger than the number at the previous index,
// we include that number in the sum for an increasing sequence up to the current index.
//But if there is a maximum sum increasing subsequence (MSIS),
// without including the number at the current index, we take that.
//So we need to find all the increasing subsequences for a number at index i,
// from all the previous numbers (i.e. numbers till index i-1), to find MSIS.

//If i represents the currentIndex and ‘j’ represents the previousIndex, our recursive formula would look like:
//if num[i] > num[j] => dp[i] = dp[j] + num[i] if there is no bigger MSIS for 'i'
public class MaximumSumIncreasingSubsequence_BUTabulation {
    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence_BUTabulation msis = new MaximumSumIncreasingSubsequence_BUTabulation();
        int[] nums = {4,1,2,6,10,1,12};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{-4,10,3,8,15};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{1,3,8,4,14,6,14,1,9,4,13,3,11,17,29};
        System.out.println(msis.findMSIS(nums));
    }

    int findMSIS(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i] = nums[i];
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && dp[i] < dp[j] + nums[i]){
                    dp[i] = dp[j] + nums[i];
                }
            }
        }
        return dp[nums.length-1];
    }
}
