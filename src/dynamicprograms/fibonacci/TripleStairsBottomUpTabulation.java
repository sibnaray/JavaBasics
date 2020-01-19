package dynamicprograms.fibonacci;

public class TripleStairsBottomUpTabulation {
    public static void main(String[] args) {
        System.out.println(countWays(3));
        System.out.println(countWays(4));
        System.out.println(countWays(5));
    }
    static int countWays(int stepsToClimb){
        if(stepsToClimb <= 2)
            return stepsToClimb;
        int[] dp = new int[stepsToClimb+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=stepsToClimb ; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[stepsToClimb];
    }
}
