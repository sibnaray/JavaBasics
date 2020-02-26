package dynamicprograms.longestcommonsubstring;

//Given a number sequence, find the length of its Longest Increasing Subsequence (LIS).
// In an increasing subsequence, all the elements are in increasing order (from lowest to highest).

//Input: {4,2,3,6,10,1,12}
//Output: 5
//Explanation: The LIS is {2,3,6,10,12}.

//Input: {-4,10,3,7,15}
//Output: 4
//Explanation: The LIS is {-4,3,7,15}.

//A basic brute-force solution could be to try all the subsequences of the given number sequence.
// We can process one number at a time, so we have two options at any step:
//
//If the current number is greater than the previous number that we included, we can increment our count
// and make a recursive call for the remaining array.

//We can skip the current number to make a recursive call for the remaining array.
//The length of the longest increasing subsequence will be the maximum number returned
// by the two recurse calls from the above two options.

public class LongestIncreasingSubsequence_Recursive {

    public static void main(String[] args) {
        LongestIncreasingSubsequence_Recursive lis = new LongestIncreasingSubsequence_Recursive();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lis.findLISLength(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(lis.findLISLength(nums));
    }

    int findLISLength(int[] nums){
        return findLISLength_Rec(nums, 0, -1);
    }

    int findLISLength_Rec(int[] nums, int ci, int pi){
        if(ci == nums.length)
            return 0;
        // include nums[currentIndex] if it is larger than the last included number
        int c1=0;
        if(pi == -1 || nums[ci] > nums[pi])
            c1 = 1 + findLISLength_Rec(nums, ci+1, ci);

        // excluding the number at currentIndex
        int c2 = findLISLength_Rec(nums, ci+1, pi);

        return Math.max(c1,c2);
    }
}
