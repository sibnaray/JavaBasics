package dynamicprograms.climbingstairs;

public class TripleStairsBottomUpMemonization {
    public static void main(String[] args) {
        System.out.println("Ways to climb 5 stairs : "+tripleStepBottomUpIterative(new int[5+1], 5));
    }
    public static int tripleStepBottomUpIterative(int[] dp, int steps){
        //BaseCase
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i<=steps;i++){
            int sum = 0;
            if(i-1 >=0)
                sum = sum + dp[i-1];
            if(i-2 >=0)
                sum = sum + dp[i-2];
            if(i-3 >=0)
                sum = sum +  dp[i-3];
            dp[i] = sum;

        }
        return dp[steps];
    }
}
