package dynamicprograms.palindromicsubsequence;

//If the element at the startIndex matches the element at the endIndex,
// the length of LPS would be two plus the length of LPS till startIndex+1 and endIndex-1.
//If the element at the startIndex does not match the element at the endIndex,
// we will take the maximum LPS created by either skipping element at the startIndex or the endIndex.

public class LongestPalindromicSubsequence_BU_Tabulation {
    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }

    static int findLPSLength(String str){
        int [][] dp = new int[str.length()][str.length()];

        for(int i = 0 ; i< str.length(); i++){
            dp[i][i] = 1;
        }

        for(int si = str.length() -1 ; si >= 0; si --){
            for(int ei = si +1; ei < str.length(); ei++){
                if(str.charAt(si) == str.charAt(ei)){
                    dp[si][ei] = 2 + dp[si+1][ei-1];
                }else{
                    dp[si][ei] = Math.max(dp[si+1][ei],dp[si][ei-1]);
                }
            }
        }
        return dp[0][str.length()-1];
    }
}
