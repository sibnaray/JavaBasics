package dynamicprograms.unboundedknapsack;

public class CoinChangeMinimum_BU_Tabulation {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        System.out.println(countChange(denominations, 5));
        System.out.println(countChange(denominations, 11));
        System.out.println(countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(countChange(denominations, 7));
    }

    static int countChange(int[] denominations, int amount){
        int[][] dp = new int[denominations.length][amount+1];

        for(int i=0;i<denominations.length;i++)
            for(int j=0; j <= amount; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }

        // populate the total=0 columns, as we don't need any coin to make zero total
        for(int i = 0 ; i< denominations.length;i++)
            dp[i][0]= 0;

        for(int i =0; i< denominations.length;i++){
            for(int j = 1; j<= amount;j++){
                if(i > 0){
                    dp[i][j] = dp[i-1][j];//exclude the coin
                }
                if(denominations[i] <= j){
                    if(dp[i][j-denominations[i]] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-denominations[i]] + 1);// include the coin
                }
            }
        }
        // total combinations will be at the bottom-right corner.
        return (dp[denominations.length-1][amount] == Integer.MAX_VALUE ? -1 : dp[denominations.length-1][amount]);
    }
}
