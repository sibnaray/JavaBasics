package dynamicprograms.fibonacci;

//There are ‘n’ houses built in a line. A thief wants to steal maximum possible money from these houses.
// The only restriction the thief has is that he can’t steal from two consecutive houses,
// as that would alert the security system. How should the thief maximize his stealing?

//Input: {2, 5, 1, 3, 6, 2, 4}
//Output: 15
//Explanation: The thief should steal from houses 5 + 6 + 4

//Input: {2, 10, 14, 8, 1}
//Output: 18
//Explanation: The thief should steal from houses 10 + 8
public class HouseThief_BU_Tabulation {
    public static void main(String[] args) {
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(findMaxSteal(wealth));
    }

    static int findMaxSteal(int[] wealth){
        int[] dp = new int[wealth.length + 1]; //accomodate no house
        dp[0] = 0;
        dp[1] = wealth[0];//if only one house return wealth

        for(int i = 1;i< wealth.length; i++){
            dp[i+1] = Math.max(dp[i-1]+wealth[i], dp[i]);
        }
        return dp[wealth.length];
    }
}
