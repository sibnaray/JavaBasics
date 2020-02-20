package dynamicprograms.palindromicsubsequence;
//Given a string, we want to cut it into pieces such that each piece is a palindrome.
// Write a function to return the minimum number of cuts needed.
//Input: "abdbca"
//Output: 3
//Explanation: Palindrome pieces are "a", "bdb", "c", "a".

//Input: = "cddpd"
//Output: 2
//Explanation: Palindrome pieces are "c", "d", "dpd".

//Input: = "pqr"
//Output: 2
//Explanation: Palindrome pieces are "p", "q", "r".
public class PalindromicPartitionTDMemoization {

    public static void main(String[] args) {
        System.out.println(findPPCuts("abdbca"));
        System.out.println(findPPCuts("cdpdd"));
        System.out.println(findPPCuts("pqr"));
        System.out.println(findPPCuts("pp"));
    }

    static private boolean isPalindrome_DP(Boolean[][] dpIsPalindrome, String st, int x, int y) {
        if(dpIsPalindrome[x][y] == null){
            dpIsPalindrome[x][y]=true;
            int i=x, j=y;
            while(i < j) {
                if(st.charAt(i++) != st.charAt(j--)){
                    dpIsPalindrome[x][y] = false;
                    break;
                }
                // use memoization to find if the remaining string is a palindrome
                if(i < j && dpIsPalindrome[i][j] != null){
                    dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
                }
            }
        }
        return dpIsPalindrome[x][y];
    }

    static int findPPCuts(String str){
        Integer[][] dp = new Integer[str.length()][str.length()];
        Boolean[][] dpIsPalindrome = new Boolean[str.length()][str.length()];
        return findPPCuts_TS_Memoization(str, dp,dpIsPalindrome,0,str.length()-1);
    }

    static int findPPCuts_TS_Memoization(String str, Integer[][] dp,Boolean[][] dpIsPalindrome, int startIndex, int endIndex){
        if(startIndex >=endIndex || isPalindrome_DP(dpIsPalindrome,str,startIndex,endIndex)){
            return 0;
        }
        if(dp[startIndex][endIndex] == null){
            int minCuts = endIndex - startIndex;
            for(int i=startIndex; i<=endIndex; i++){
                if(isPalindrome_DP(dpIsPalindrome,str,startIndex,i)){
                    minCuts = Math.min(minCuts, 1+ findPPCuts_TS_Memoization(str,dp,dpIsPalindrome,i+1,endIndex));
                }
            }
            dp[startIndex][endIndex]=minCuts;
        }
        return dp[startIndex][endIndex];
    }
}
