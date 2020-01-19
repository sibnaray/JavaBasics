package dynamicprograms.fibonacci;

public class NumberFactor_BU_Tabulation {
    public static void main(String[] args) {
        //1, 3, or 4.
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(6));
    }

    static int countWays(int num){
        int[] dp = new int[num + 1];
        for(int i = 0; i<= num; i++){
            if(i == 0)
                dp[i] = 1;
            else if(i == 1)
                dp[i] = 1;//{1}
            else if(i == 2)
                dp[i] = 1;//{1 , 1}
            else if(i == 3)
                dp[i] = 2;//{1, 1, 1 , 1},{3}
            else{
                dp[i] = dp[i - 4] + dp[i - 3] + dp[i - 1];
            }
        }
        return dp[num];
    }
}
