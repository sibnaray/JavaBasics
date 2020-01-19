package dynamicprograms.fibonacci;

public class NumberFactor_TD_Memoization {
    public static void main(String[] args) {
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(6));
    }

    static int countWays(int num){
        Integer[] dp = new Integer[num+1];
        return countWays_TD(dp,num);
    }

    static int countWays_TD(Integer[] dp, int num){
        if(num == 0)
            return 1;
        if(num == 1)
            return 1;
        if(num == 2)
            return 1;
        if(num == 3)
            return 2;
        if(dp[num] == null){
            int sum1 = countWays_TD(dp,num -1);
            int sum3 = countWays_TD(dp,num - 3);
            int sum4 = countWays_TD(dp, num - 4);
            dp[num] = sum1 + sum3 + sum4;
        }
        return dp[num];
    }
}
