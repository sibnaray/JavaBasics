package dynamicprograms.unboundedknapsack;

public class CoinChange_BU_Tabulation {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        System.out.println(countChange(denominations, 5));
    }
    static int countChange(int[] denominations, int amount){
        if(denominations.length==0 || amount == 0)
            return 0;
        int[][] dp = new int[denominations.length][amount+1];

        // populate the total=0 columns, as we will always have an empty set for zero toal
        for(int i=0 ; i<denominations.length; i++)
            dp[i][0] = 1;
        for(int i=0; i<denominations.length; i++){
            for(int a=1; a<=amount; a++){
                if(denominations[i] <= a){
                    dp[i][a] = dp[i][a] + dp[i][a-denominations[i]];
                }
                if(i>0)
                    dp[i][a] = dp[i][a] + dp[i-1][a];
            }
        }
        return dp[denominations.length-1][amount];
    }
}
