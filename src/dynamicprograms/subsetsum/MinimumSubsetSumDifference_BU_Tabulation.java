package dynamicprograms.subsetsum;

public class MinimumSubsetSumDifference_BU_Tabulation {
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
        //We are trying to find a sum close to sum/2. So will find a subset which is equal or less that s/2

        boolean[][] dp = new boolean[num.length][sum/2 + 1];
        for(int i=0;i<num.length;i++){
            dp[i][0]=true; //empty set adds to sum 0
        }
        for(int s=1;s<=sum/2;s++){
            dp[0][s]=s==num[0]?true:false;
        }

        for(int i=1;i<num.length;i++){
            for(int s=1;s<= sum/2 ;s++){
                if(dp[i-1][s]){
                    dp[i][s] = dp[i-1][s];//exclude and still got the element;
                }else if(num[i]<=s){
                    dp[i][s]=dp[i-1][s-num[i]];
                }
            }
        }
        if(dp[num.length-1][sum/2]==true)
            return 0;
        else{
            int sum2=0;
            for(int s=sum/2;s>=0;s--){
                if(dp[num.length-1][s]){
                    sum2 = s;
                    break;
                }
            }
            return Math.abs((sum-sum2)-sum2);
        }
    }
}
