package dynamicprograms.longestcommonsubstring;

//The above algorithm shows us a clear bottom-up approach. We can separately calculate LDS for every index i.e.,
// from the beginning to the end of the array and vice versa.
// The required length of MBS would be the one that has the maximum sum of LDS for a given index (from both the ends).
public class BitonicSubsequence_BU_Tabulation {
    public static void main(String[] args) {
        BitonicSubsequence_BU_Tabulation lbs = new BitonicSubsequence_BU_Tabulation();
        int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
        System.out.println(lbs.findLBSLength(nums));
        nums = new int[] { 4, 2, 5, 9, 7, 6, 10, 3, 1 };
        System.out.println(lbs.findLBSLength(nums));
    }

    int findLBSLength(int[] nums){
        int[] longestDecSeq = new int[nums.length];
        int[] longestDecSeqRev = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            longestDecSeq[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i])
                    longestDecSeq[i]=Math.max(longestDecSeq[i],longestDecSeq[j]+1);
            }
        }

        for(int i=nums.length-1;i>=0;i--){
            longestDecSeqRev[i]=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[i])
                    longestDecSeqRev[i]=Math.max(longestDecSeqRev[i],longestDecSeqRev[j]+1);
            }
        }

        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            maxLength=Math.max(maxLength,longestDecSeqRev[i]+longestDecSeq[i]-1);
        }
        return maxLength;
    }
}
