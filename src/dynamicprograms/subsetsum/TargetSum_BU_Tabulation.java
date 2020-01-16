package dynamicprograms.subsetsum;

//Given a set of positive numbers (non zero) and a target sum ‘S’.
// Each number should be assigned either a ‘+’ or ‘-’ sign.
// We need to find out total ways to assign symbols to make the sum of numbers equal to target ‘S’.
//Input: {1, 1, 2, 3}, S=1
//        Output: 3
//        Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
//We are asked to find two subsets of the given numbers whose difference is equal to the given target ‘S’.
//Sum(s1)’ denotes the total sum of set ‘s1’, and ‘Sum(s2)’ denotes the total sum of set ‘s2’.
// So the required equation is:Sum(s1) - Sum(s2) = S

//Let’s assume that ‘Sum(num)’ denotes the total sum of all the numbers, therefore:
// Sum(s1) + Sum(s2) = Sum(num)
//=> Sum(s1) - Sum(s2) + Sum(s1) + Sum(s2) = S + Sum(num)
//        => 2 * Sum(s1) =  S + Sum(num)
//        => Sum(s1) = (S + Sum(num)) / 2

//This essentially converts our problem to: “Find count of subsets of the given numbers whose sum is equal to”,
// => (S + Sum(num)) / 2

public class TargetSum_BU_Tabulation {
    public static void main(String[] args) {
        int[] num = {1, 1, 2, 3};
        System.out.println(findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(findTargetSubsets(num, 9));
    }

    static int findTargetSubsets(int[] num, int sum){
        int totalSum  = 0;
        for(int i =0;i<num.length;i++){
            totalSum=totalSum+num[i];
        }

        // if 's + totalSum' is odd, we can't find a subset with sum equal to '(s + totalSum) / 2'
        if(totalSum < sum || (sum + totalSum) % 2 == 1)
            return 0;

        int targetSum = (sum+totalSum)/2;

        int[][] dp = new int[num.length][targetSum+1];
        for(int i=0;i<num.length;i++){
            dp[i][0]=1;
        }
        for(int s=1;s<=targetSum;s++){
            dp[0][s] = num[0]==s ? 1 : 0;
        }

        for(int i =1 ; i<num.length; i++){
            for(int s = 1; s<=targetSum; s++){
                dp[i][s]=dp[i-1][s];
                if(num[i]<=s){
                    dp[i][s]=dp[i][s]+dp[i-1][s-num[i]];
                }
            }
        }

        return dp[num.length-1][targetSum];
    }
}
