package dynamicprograms.fibonacci;

public class MinimumJumpCountToArrayEnd_TD_Memoization {
    public static void main(String[] args) {
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(countMinJumps(jumps));
    }

    static int countMinJumps(int[] jumps){
        Integer[] dp = new Integer[jumps.length];
        return countMinJumps_TD(dp,jumps,0);
    }

    static int countMinJumps_TD(Integer[] dp,int[] jumps, int currentIndex){
        if(currentIndex == jumps.length-1)
            return 0;

        if(currentIndex >= jumps.length || jumps[currentIndex] == 0)
            return Integer.MAX_VALUE;

        if(dp[currentIndex] == null){
            int totJump = Integer.MAX_VALUE;
            int start = currentIndex+1;
            int end =  currentIndex + jumps[currentIndex];
            while(start < jumps.length && start <= end){
                int minJump = countMinJumps_TD(dp,jumps,start++);
                if(minJump != Integer.MAX_VALUE)
                    totJump = Math.min(totJump,minJump+1);
            }
            dp[currentIndex] = totJump;
        }
        return dp[currentIndex];
    }
}
