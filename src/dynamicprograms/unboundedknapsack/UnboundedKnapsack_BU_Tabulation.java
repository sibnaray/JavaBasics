package dynamicprograms.unboundedknapsack;

public class UnboundedKnapsack_BU_Tabulation {
    public static void main(String[] args) {
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }

    static int solveKnapsack(int[] profits,int[] weights, int capacity){
        if(profits.length==0 || profits.length != weights.length || capacity<=0)
            return 0;

        int[][] dp = new int[profits.length][capacity+1];
        for(int i = 0;i<profits.length;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<profits.length;i++){
            for(int c=1;c<=capacity;c++){
                int profit1=0, profit2=0;
                if(weights[i]<=c){
                    profit1=profits[i] + dp[i][c-weights[i]];
                }
                if(i>0){
                    //only for more than 1 item we will look for i-1.
                    //not including current item.
                    profit2=dp[i-1][c];

                }
                dp[i][c]=Math.max(profit1,profit2);
            }
        }
        return dp[profits.length-1][capacity];
    }
}
