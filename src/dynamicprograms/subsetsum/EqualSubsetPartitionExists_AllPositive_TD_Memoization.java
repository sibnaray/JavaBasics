package dynamicprograms.subsetsum;

public class EqualSubsetPartitionExists_AllPositive_TD_Memoization {

    static boolean canPartitions(int[] num){
        int sum = 0;
        for(int i = 0;i<num.length;i++){
            sum = sum + num[i];
        }
        if(sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[num.length][(sum/2)+1];
        return canPartitions_TD_Recursive(dp,num,sum/2,0);
    }

    static boolean canPartitions_TD_Recursive(Boolean[][] dp, int[] num, int sum, int numIndex){
        if(sum == 0)
            return true;

        if(num.length == 0 ||  numIndex >= num.length)
            return false;

        if(dp[numIndex][sum]==null){
            if(num[numIndex]<=sum){
                if(canPartitions_TD_Recursive(dp,num,sum-num[numIndex],numIndex+1)){
                    dp[numIndex][sum]=true;
                    return true;
                }
            }
            dp[numIndex][sum]=canPartitions_TD_Recursive(dp,num,sum,numIndex+1);
        }
        return dp[numIndex][sum];
    }

    public static void main(String[] args) {
        int[] num = { 1, 2, 3, 4 };
        System.out.println(canPartitions(num));
        num = new int[] { 1, 1, 3, 4, 7 };
        System.out.println(canPartitions(num));
        num = new int[] { 2, 3, 4, 6 };
        System.out.println(canPartitions(num));
    }
}
