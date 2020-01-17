package dynamicprograms.unboundedknapsack;

public class UnboundedKnapsack_TD_Memoization {
    public static void main(String[] args) {
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }

    static int solveKnapsack(int[] profits, int[] weights,int capacity){
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return solveKnapsack_TD_Recursion(dp,profits,weights,capacity,0);
    }
    static int solveKnapsack_TD_Recursion(Integer[][] dp,int[] profits, int[] weights,int capacity,int currentIndex){
        if(capacity<=0 || profits.length == 0 || profits.length!=weights.length || currentIndex >= profits.length)
            return 0;
        if(dp[currentIndex][capacity] == null){
            int profit1 = 0;
            if(weights[currentIndex] <= capacity){
            // recursive call after choosing the items at the currentIndex, note that we recursive call on all
            // items as we did not increment currentIndex
                profit1=profits[currentIndex]+solveKnapsack_TD_Recursion(dp,profits,weights,
                        capacity-weights[currentIndex],currentIndex);
            }
            int profit2 = 0;
            profit2 = solveKnapsack_TD_Recursion(dp,profits,weights,capacity,currentIndex+1);
            dp[currentIndex][capacity]=Math.max(profit1,profit2);
        }
        return dp[currentIndex][capacity];
    }
}
