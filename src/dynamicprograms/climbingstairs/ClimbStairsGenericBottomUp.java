package dynamicprograms.climbingstairs;

public class ClimbStairsGenericBottomUp {
    public static void main(String[] args) {
        int[] steps = {2,3};
        int n = 8;
        System.out.println(countWaysToClimb(steps,n));
    }
    public static long countWaysToClimb(int[] steps, int n) {
        long[] dp = new long[n+1];
        //basecase
        dp[0]=1;
        for(int fs = 1;fs<=n;fs++){
            for(int s : steps){
                if(fs-s >= 0)
                    dp[fs] = dp[fs]+dp[fs-s];
            }
        }
        return dp[n];
    }
}
