package dynamicprograms.subsetsum;

public class MinimumSubsetSumDifference_TD_Memoization {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 9};
        System.out.println(canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(canPartition(num));
    }

    static int canPartition(int[] num){
        int sum=0;
        for(int i=0;i<num.length;i++)
            sum=sum+num[i];

        Integer[][] dp = new Integer[num.length][sum + 1];
        return canPartition_TD(num,dp,0,0,0);
    }

    static int canPartition_TD(int[] num,Integer[][] dp, int currentIndex,int S1,int S2){
        if(currentIndex >= num.length)
            return Math.abs(S1-S2);

        if(dp[currentIndex][S1]==null){
            int diff1=canPartition_TD(num,dp,currentIndex+1,S1+num[currentIndex],S2);
            int diff2=canPartition_TD(num,dp,currentIndex+1,S1,S2+num[currentIndex]);
            dp[currentIndex][S1]=Math.min(diff1,diff2);
        }
        return dp[currentIndex][S1];
    }
}
