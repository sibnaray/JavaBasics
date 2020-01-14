package dynamicprograms.subsetsum;

public class SubsetSum_SumIsGiven_BU {
    public static void main(String[] args) {
        int[] num = { 1, 2, 3, 7 };
        System.out.println(canPartitions(num,6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(canPartitions(num,10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(canPartitions(num,6));
    }

    static boolean canPartitions(int[] num, int sum){
        boolean[][] dp = new boolean[num.length][sum+1];

        for(int ni=0;ni<num.length;ni++){
            dp[ni][0]=true;
        }

        for(int s=0;s <= sum ;s++){
            dp[0][s]=num[0]==s?true:false;
        }

        for(int ni=1;ni<num.length;ni++){
            for(int s=1; s<= sum; s++){
                //sum can be reached without including element at 'ni'
                if(dp[ni-1][s])
                    dp[ni][s]=dp[ni-1][s];
                else if(s>=num[ni]){
                    dp[ni][s]=dp[ni-1][s-num[ni]];
                }
            }
        }
        return dp[num.length-1][sum];
    }
}
