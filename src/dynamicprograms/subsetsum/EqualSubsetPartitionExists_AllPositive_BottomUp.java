package dynamicprograms.subsetsum;

public class EqualSubsetPartitionExists_AllPositive_BottomUp {
    static boolean canPartitions(int[] num){
        int sum = 0;
        for(int i = 0;i<num.length;i++){
            sum = sum + num[i];
        }
        if(sum % 2 != 0)
            return false;


        return canPartitions_BottomUp(num,sum/2);
    }

    static boolean canPartitions_BottomUp(int[] num, int sum){
        if(num.length==0)
            return false;
        boolean[][] dp = new boolean[num.length][sum+1];

        //Sum of 0 can be made with empty set
        for(int i=0;i<num.length;i++){
            dp[i][0]=true;
        }

        //when only one element present in set sum is true when element equals sum
        for(int s=0;s<=sum;s++){
            dp[0][s]=num[0]==s?true:false;
        }

        for(int i=1;i<num.length;i++){
            for(int s=1;s<=sum;s++){
                //if we can get sum without element
                if(dp[i-1][s]){
                    dp[i][s]=dp[i-1][s];
                }else if(s >= num[i]){
                    dp[i][s]=dp[i-1][s-num[i]];
                }
            }
        }
        return dp[num.length-1][sum];
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartitions(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartitions(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(canPartitions(num));
    }
}
