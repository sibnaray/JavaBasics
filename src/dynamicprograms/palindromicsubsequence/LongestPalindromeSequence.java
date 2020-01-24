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

public class LongestPalindromeSequence {
    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }

    static int findLPSLength(String str){
        return findLPSLength_Recursive(str, 0, str.length()-1);
    }

    static int findLPSLength_Recursive(String str, int si, int ei){
        if(si > ei)
            return 0;

        if(si == ei)
            return 1;

        if(str.charAt(si) == str.charAt(ei)){
            int remainingLen = ei - si - 1;
            if(remainingLen == findLPSLength_Recursive(str, si+1, ei-1)){
                return 2 + remainingLen;
            }
        }
        int c1 = findLPSLength_Recursive(str, si+1, ei);
        int c2 = findLPSLength_Recursive(str, si, ei-1);
        return Math.max(c1,c2);
    }
}
