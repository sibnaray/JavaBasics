package dynamicprograms.fibonacci;

import java.util.Arrays;

public class MinimumJumpCountToArrayEnd_BU_Tabulation {
    public static void main(String[] args) {
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(countMinJumps(jumps));
    }

    static int countMinJumps(int[] jumps){
        int[] dp = new int[jumps.length];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        //initialize with infinity, except the first index which should be zero as we start from there
        //every index within the range of current index can be reached in one jump. Therefore,
        // we can say that we can reach every index (within the range of current index)
        // in:'jumps to reach current index' + 1
        for(int start = 0 ; start < jumps.length; start++){
            for(int end = start + 1; end <= start + jumps[start] && end < jumps.length; end++){
                dp[end] = Math.min(dp[end],dp[start] + 1);
            }
        }
        return dp[jumps.length-1];
    }
}
