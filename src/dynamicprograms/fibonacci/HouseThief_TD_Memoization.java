package dynamicprograms.fibonacci;

// The only restriction the thief has is that he can’t steal from two consecutive houses,
// as that would alert the security system. How should the thief maximize his stealing?

//Input: {2, 5, 1, 3, 6, 2, 4}
//Output: 15
//Explanation: The thief should steal from houses 5 + 6 + 4

//Input: {2, 10, 14, 8, 1}
//Output: 18
//Explanation: The thief should steal from houses 10 + 8

public class HouseThief_TD_Memoization {
    public static void main(String[] args) {
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(findMaxSteal(wealth));
    }

    static int findMaxSteal(int[] wealth){
        int dp[] = new int[wealth.length];
        return findMaxSteal_Recursive(dp, wealth, 0);
    }

    static int findMaxSteal_Recursive(int[] dp, int[] wealth, int currentIndex){
        if(currentIndex > wealth.length-1)
            return 0;

        if(dp[currentIndex] == 0){
            int includeHouse = wealth[currentIndex] + findMaxSteal_Recursive(dp,wealth, currentIndex + 2);
            int excludeHouse = findMaxSteal_Recursive(dp,wealth,currentIndex +  1);
            dp[currentIndex] = Math.max(includeHouse, excludeHouse);
        }
        return dp[currentIndex];
    }
}
