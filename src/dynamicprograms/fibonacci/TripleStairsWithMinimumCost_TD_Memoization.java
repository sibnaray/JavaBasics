package dynamicprograms.fibonacci;

public class TripleStairsWithMinimumCost_TD_Memoization {
    public static void main(String[] args) {
        int[] fee = {1,2,5,2,1,2};
        System.out.println(findMinFee(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(findMinFee(fee));
    }

    static int findMinFee(int[] fee){
        int[] dp = new int[fee.length];
        return findMinFeeRecursive(dp,fee,0);
    }

    static int findMinFeeRecursive(int[] dp, int[] fee, int currentIndex){
        if(currentIndex > fee.length - 1)
            return 0;

        if(dp[currentIndex]==0){
            int step1Fee = findMinFeeRecursive(dp,fee, currentIndex + 1);
            int step2Fee = findMinFeeRecursive(dp,fee, currentIndex + 2);
            int step3Fee = findMinFeeRecursive(dp,fee, currentIndex + 3);

            int minFee = Math.min(Math.min(step1Fee,step2Fee),step3Fee);
            dp[currentIndex] = minFee + fee[currentIndex];
        }
        return dp[currentIndex];
    }
}
