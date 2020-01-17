package dynamicprograms.unboundedknapsack;

public class CuttingGoldRodeMaximumProfit_Recursion {
    public static void main(String[] args) {
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }

    static int solveRodCutting(int[] lengths, int[] prices, int rodLength){
        if(lengths.length == 0 || lengths.length != prices.length || rodLength==0)
            return 0;

        int[][] dp = new int[lengths.length][rodLength+1];

        for(int l=0;l<lengths.length;l++){
            dp[l][0] = 0;
        }

        for(int l=0 ; l<lengths.length; l++){
            for(int rl=1; rl<=rodLength; rl++){
                int profit1=0, profit2=0;
                if(lengths[l]<=rl){
                    profit1 = prices[l] + dp[l][rl-lengths[l]];
                }
                if(l>0){
                    profit2 = dp[l-1][rl];
                }
                dp[l][rl] = Math.max(profit1,profit2);
            }
        }
        return dp[lengths.length-1][rodLength];
    }
}
