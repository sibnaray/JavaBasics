package dynamicprograms.palindromicsubsequence;

//Given a string, find the length of its Longest Palindromic Substring (LPS).
// In a palindromic string, elements read the same backward and forward.
//Input: "abdbca"
//Output: 3
//Explanation: LPS is "bdb".

//Input: = "cddpd"
//Output: 3
//Explanation: LPS is "dpd".

//Input: = "pqr"
//Output: 1
//Explanation: LPS could be "p", "q" or "r".

//1) If the element at the beginning and the end are the same, we make a recursive call to check if the
// remaining substring is also a palindrome. If so, the substring is a palindrome from beginning to the end.

//2) We will skip either the element from the beginning or the end to make two recursive calls for the
// remaining substring. The length of LPS would be the maximum of these two recursive calls.
public class LongestPalindromeSubString_TD_Memoization {
    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }

    static int findLPSLength(String str){
        Integer[][] dp = new Integer[str.length()][str.length()];
        return findLPSLength_TD(dp,str, 0, str.length()-1);
    }

    static int findLPSLength_TD(Integer[][] dp, String str, int si, int ei){
        if(si > ei)
            return 0;
        if(si == ei)
            return 1;

        if(dp[si][ei]==null){
            if(str.charAt(si) == str.charAt(ei)){
                int remainingLen = ei - si -1;
                if(remainingLen == findLPSLength_TD(dp,str,si+1,ei-1))
                    return 2 + remainingLen;
            }
            int c1 = findLPSLength_TD(dp,str,si+1,ei);
            int c2 = findLPSLength_TD(dp,str,si, ei-1);
            dp[si][ei] = Math.max(c1,c2);
        }
        return dp[si][ei];
    }
}
