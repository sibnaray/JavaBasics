package dynamicprograms.palindromicsubsequence;

//Given a string, find the total number of palindromic substrings in it.
// Please note we need to find the total number of substrings and not subsequences.

//Input: "abdbca"
//Output: 7
//Explanation: Here are the palindromic substrings, "a", "b", "d", "b", "c", "a", "bdb".

//Input: = "cddpd"
//Output: 7
//Explanation: Here are the palindromic substrings, "c", "d", "d", "p", "d", "dd", "dpd".

//Input: = "pqr"
//Output: 3
//Explanation: Here are the palindromic substrings,"p", "q", "r".

//This problem follows the Longest Palindromic Subsequence pattern, and can be easily converted to
// Longest Palindromic Substring. The only difference is that instead of calculating the
// longest palindromic substring, we will instead count all the palindromic substrings.

public class CountPaliendromeSubString_BU_Tabulation {
    public static void main(String[] args) {
        System.out.println(findCPS("abdbca"));
        System.out.println(findCPS("cdpdd"));
        System.out.println(findCPS("pqr"));
    }

    static int findCPS(String str){
        boolean [][] dp = new boolean[str.length()][str.length()];

        int count = 0;
        for(int i = 0; i<str.length(); i++){
            dp[i][i] = true;
            count++;
        }

        for(int si = str.length()-1; si>=0; si --){
            for(int ei = si + 1; ei<str.length(); ei++){
                if(str.charAt(si) == str.charAt(ei)){
                    if(ei - si == 1 || dp[si+1][ei-1]){
                        dp[si][ei] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
