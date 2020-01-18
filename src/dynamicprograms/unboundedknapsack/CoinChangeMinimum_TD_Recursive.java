package dynamicprograms.unboundedknapsack;

public class CoinChangeMinimum_TD_Recursive {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        System.out.println(countChange(denominations, 5));
        System.out.println(countChange(denominations, 11));
        System.out.println(countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(countChange(denominations, 7));
    }

    static int countChange(int[] denominations, int amount){
        Integer[][] dp = new Integer[denominations.length][amount+1];
        int result = countChangeRecursive(dp,denominations, amount,0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int countChangeRecursive(Integer[][] dp, int[] denominations, int amount, int currentIndex){
        if(amount == 0)
            return 0;

        if(denominations.length==0 || currentIndex >= denominations.length)
            return Integer.MAX_VALUE;

        if(dp[currentIndex][amount] == null){
            int count1 = Integer.MAX_VALUE;
            if(denominations[currentIndex] <= amount){
                int res = countChangeRecursive(dp,denominations,amount-denominations[currentIndex],currentIndex);
                if(res != Integer.MAX_VALUE)
                    count1 = res + 1;
            }

            int count2 = countChangeRecursive(dp,denominations,amount,currentIndex+1);
            dp[currentIndex][amount] = Math.min(count1,count2);
        }
        return dp[currentIndex][amount];
    }
}
