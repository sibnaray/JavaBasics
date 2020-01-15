package dynamicprograms.subsetsum;

public class CountSubsetSum_TD_Memoization {
    public static void main(String[] args) {
        int[] num = {1, 1, 2, 3};
        System.out.println(countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(countSubsets(num, 9));
    }

    static int countSubsets(int[] num, int sum){
        Integer[][] dp= new Integer[num.length][sum+1];
        return countSubsetsRecursive(dp,num,sum,0);

    }


    static int countSubsetsRecursive(Integer[][] dp,int[] num,int sum, int currentIndex){
        if(sum==0)
            return 1;

        if(currentIndex >= num.length || num.length==0)
            return 0;

        if(dp[currentIndex][sum]==null){
            int count1 = 0;
            if(num[currentIndex] <= sum )
                count1 = countSubsetsRecursive(dp,num,sum-num[currentIndex],currentIndex + 1);

            int count2 = countSubsetsRecursive(dp,num,sum,currentIndex+1);

            dp[currentIndex][sum] = count1 + count2;
        }
        return dp[currentIndex][sum];
    }
}
