package dynamicprograms.longestcommonsubstring;

//Given a number sequence, find the increasing subsequence with the highest sum.
// Write a method that returns the highest sum.

//Input: {4,1,2,6,10,1,12}
//Output: 32
//Explanation: The increaseing sequence is {4,6,10,12}.
//Please note the difference, as the LIS is {1,2,6,10,12} which has a sum of '31'.

//Example 2:
//Input: {-4,10,3,7,15}
//Output: 25
//Explanation: The increaseing sequences are {10, 15} and {3,7,15}.

public class MaximumSumIncreasingSubsequence_Recursive {
    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence_Recursive msis = new MaximumSumIncreasingSubsequence_Recursive();
        int[] nums = {4,1,2,6,10,1,12};
        System.out.println(msis.findMSIS(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(msis.findMSIS(nums));
    }

    int findMSIS(int[] nums){
        return findMSIS_Rec(nums,0, -1,0);
    }

    int findMSIS_Rec(int[] nums, int curIndex, int prevIndex, int sum){
        if(curIndex == nums.length)
            return sum;

        int s1 = sum;
        if(prevIndex == -1 || nums[curIndex] > nums[prevIndex]){
            s1 = findMSIS_Rec(nums, curIndex+1, curIndex, sum+nums[curIndex]);
        }

        int s2 = findMSIS_Rec(nums, curIndex+1, prevIndex, sum);

        return Math.max(s1, s2);
    }
}
