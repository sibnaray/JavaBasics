package dynamicprograms.longestcommonsubstring;

//A basic brute-force solution could be to try finding the LAS starting from every number in both ascending and descending order.
// So for every index ‘i’ in the given array, we will have three options:
//
// 1)If the element at ‘i’ is bigger than the last element we considered, we include the element at ‘i’ and
// recursively process the remaining array to find the next element in descending order.
// 2)If the element at ‘i’ is smaller than the last element we considered, we include the element at ‘i’ and
// recursively process the remaining array to find the next element in ascending order.
// 3) In addition to the above two cases, we can always skip the element ‘i’ to recurse for the remaining array.
// This will ensure that we try all subsequences.
//LAS would be the maximum of the above three subsequences.

//{a1 > a2 < a3 } or { a1 < a2 > a3}.

//Input: {3,2,1,4}
//Output: 3
//Explanation: The LAS are {3,2,4} and {2,1,4}.  3>2<4   2>1<4

//Input: {1,3,2,4}
//Output: 4
//Explanation: The LAS is {1,3,2,4}.  1<3>2<4

//Input: {1,2,3,4}
//Output: 2
//Explanation: There are many LAS: {1,2}, {3,4}, {1,3}, {1,4}, because its already in asc

public class LongestAlternatingSubsequence_Rec {

    public static void main(String[] args) {
        LongestAlternatingSubsequence_Rec las = new LongestAlternatingSubsequence_Rec();
        int[] nums = {1,2,3,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLength(nums));
    }

    int findLASLength(int[] nums){
        return Math.max(findLASLength_Rec(nums,-1,0,true),
                findLASLength_Rec(nums,-1,0,false));
    }

    int findLASLength_Rec(int[] nums, int prevIndex, int curIndex, boolean isAsc){
        if(curIndex==nums.length)
            return 0;
        int c1=0;
        //if isAsc then check for previous element < cuurentElement
        if(isAsc){
            if (prevIndex == -1 || nums[prevIndex] < nums[curIndex])
                c1 = 1 + findLASLength_Rec(nums, curIndex, curIndex+1,!isAsc);
        }else{
            //if isAsc then check for previousElement > cuurentElement
            if(prevIndex == -1 || nums[prevIndex] > nums[curIndex])
                c1 = 1 + findLASLength_Rec(nums, curIndex, curIndex+1, !isAsc);
        }

        int c2 = findLASLength_Rec(nums, prevIndex, curIndex+1, isAsc);
        return Math.max(c1,c2);
    }
}
