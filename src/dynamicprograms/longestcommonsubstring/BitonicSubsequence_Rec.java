package dynamicprograms.longestcommonsubstring;

//Given a number sequence, find the length of its Longest Bitonic Subsequence (LBS).
// A subsequence is considered bitonic if it is monotonically increasing and then monotonically decreasing.

//Input: {4,2,3,6,10,1,12}
//Output: 5
//Explanation: The LBS is {2,3,6,10,1}.

//Input: {4,2,5,9,7,6,10,3,1}
//Output: 7
//Explanation: The LBS is {4,5,9,7,6,3,1}.

public class BitonicSubsequence_Rec {
    public static void main(String[] args) {
        BitonicSubsequence_Rec lbs = new BitonicSubsequence_Rec();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lbs.findLBSLength(nums));
        nums = new int[]{4,2,5,9,7,6,10,3,1};
        System.out.println(lbs.findLBSLength(nums));
    }

    int findLBSLength(int[] nums){
        int maxLength=0;
        for(int i=0; i< nums.length; i++){
            int c1=findLongestIncreasingSeq(nums,i,-1);
            int c2=findLongestDecreasingSeq(nums,i,-1);
            maxLength=Math.max(maxLength,c1+c2-1);
        }
        return maxLength;
    }

    int findLongestIncreasingSeq(int[] nums, int currIndex, int prevIndex){
        if(currIndex==nums.length)
            return 0;

        // include nums[currentIndex] if it is smaller than the previous number
        int c1 = 0;
        if(prevIndex==-1 || nums[currIndex] < nums[prevIndex])
            c1=1+findLongestIncreasingSeq(nums,currIndex+1,currIndex);
        int c2 = findLongestIncreasingSeq(nums,currIndex+1,prevIndex);

        return Math.max(c1,c2);
    }

    int findLongestDecreasingSeq(int[] nums, int currIndex, int prevIndex){
        if(currIndex<0)
            return 0;

        // include nums[currentIndex] if it is smaller than the previous number
        int c1 = 0;
        if(prevIndex==-1 ||nums[currIndex] < nums[prevIndex]){
            c1=1+findLongestDecreasingSeq(nums,currIndex-1,currIndex);
        }
        int c2 = findLongestDecreasingSeq(nums,currIndex-1,prevIndex);
        return Math.max(c1,c2);
    }

}
