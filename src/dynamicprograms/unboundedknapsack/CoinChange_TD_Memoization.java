package dynamicprograms.unboundedknapsack;

public class CoinChange_TD_Memoization {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        System.out.println(countChange(denominations, 5));
    }

    static int countChange(int[] denomination, int amount){
        Integer[][] dp = new Integer[denomination.length][amount+1];
        return countChangeRecursive(dp,denomination,amount,0);
    }

    static int countChangeRecursive(Integer[][] dp,int[] denomination, int amount, int currentIndex){
        if(amount == 0)
            return 1;
        if(denomination.length == 0 || currentIndex >= denomination.length){
            return 0;
        }

        if(dp[currentIndex][amount]==null){
            int tot1=0;
            if(denomination[currentIndex]<=amount)
                tot1 = countChangeRecursive(dp,denomination,amount - denomination[currentIndex], currentIndex);

            int tot2=countChangeRecursive(dp,denomination,amount , currentIndex+1);
            dp[currentIndex][amount] = tot1 + tot2;
        }
        return dp[currentIndex][amount];
    }
}
