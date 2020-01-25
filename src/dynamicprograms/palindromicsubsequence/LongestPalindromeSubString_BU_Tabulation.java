package dynamicprograms.palindromicsubsequence;
//Bottom-up Dynamic Programming #
//Since we want to try all the substrings of the given string, we can use a two-dimensional
// array to store the subproblems’ results. So dp[i][j] will be ‘true’ if the substring from index ‘i’ to index ‘j’ is a palindrome.
//
//We can start from the beginning of the string and keep adding one element at a time.
// At every step, we will try all of its substrings. So for every endIndex and startIndex
// in the given string, we need to check the following thing:
//
//If the element at the startIndex matches the element at the endIndex, we will further check if the remaining substring
// (from startIndex+1 to endIndex-1) is a substring too.
public class LongestPalindromeSubString_BU_Tabulation {
    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }

    static int findLPSLength(String str){
        // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
        // palindrome
        boolean[][] dp = new boolean[str.length()][str.length()];

        // every string with one character is a palindrome
        for(int i = 0; i < str.length(); i++)
            dp[i][i] = true;

        int maxLength=1;
        for(int si = str.length()-1; si>=0; si--){
            for(int ei=si+1; ei< str.length();ei++){
                if(str.charAt(si) == str.charAt(ei)){
                    // if it's a two character string or if the remaining string is a palindrome too
                    if(ei - si == 1 || dp[si+1][ei-1])
                        maxLength = Math.max(maxLength,ei - si + 1);
                }
            }
        }
        return maxLength;
    }
}
