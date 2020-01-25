package dynamicprograms.palindromicsubsequence;

//Given a string, find the minimum number of characters that we can remove to make it a palindrome.

//This problem can be easily converted to the Longest Palindromic Subsequence (LPS) problem.
// We can use the fact that LPS is the best subsequence we can have, so any character that is
// not part of LPS must be removed. Please note that
// it is ‘Longest Palindromic SubSequence’ and not ‘Longest Palindrome Substring’.
//
//So, our solution for a given string ‘st’ will be: Minimum_deletions_to_make_palindrome = Length(st) - LPS(st)

public class MinimumDeletionPaliendrome_BU_Tabulation {
    public static void main(String[] args) {
        System.out.println(findMinimumDeletions("abdbca"));
        System.out.println(findMinimumDeletions("cddpd"));
        System.out.println(findMinimumDeletions("pqr"));
    }

    static int findMinimumDeletions(String str){
        int [][] dp = new int[str.length()][str.length()];

        for(int i = 0 ; i< str.length(); i++)
            dp[i][i] = 1;

        for(int si=str.length()-1; si>=0; si--){
            for(int ei=si+1; ei<str.length(); ei++){
                if(str.charAt(si) == str.charAt(ei)){
                    dp[si][ei] = 2 + dp[si+1][ei-1];
                }else{
                    dp[si][ei] = Math.max(dp[si+1][ei],dp[si][ei-1]);
                }
            }
        }
        return str.length() - dp[0][str.length()-1];
    }
}
