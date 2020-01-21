package dynamicprograms.palindromicsubsequence;

//Given a sequence, find the length of its Longest Palindromic Subsequence (LPS). In a palindromic subsequence,
// elements read the same backward and forward.
//
//A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
// changing the order of the remaining elements.

//Input: "abdbca"
//Output: 5
//Explanation: LPS is "abdba". We skip 'c'.

//Input: = "cddpd"
//Output: 3
//Explanation: LPS is "ddd". // we skip 'c' and 'd'.

//Input: = "pqr"
//Output: 1
//Explanation: LPS could be "p", "q" or "r".

//So at any step, we have two options:
//
//If the element at the beginning and the end are the same, we increment our count by two and make a recursive call for the remaining sequence.
//We will skip the element either from the beginning or the end to make two recursive calls for the remaining subsequence.

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }

    static int findLPSLength(String str){
        return findLPSLength_Recursive(str,0, str.length()-1);
    }

    static int findLPSLength_Recursive(String str, int si, int ei){
        if(si > ei)
            return 0;
        if(si == ei)
            return 1;//only one character

        //if characters and same we can include both in palindromic sequence
        if(str.charAt(si) == str.charAt(ei))
            return 2 + findLPSLength_Recursive(str,si+1,ei-1);
        else{
            //else skip one from beginning or end and find the max ength
            int c1 = findLPSLength_Recursive(str,si+1,ei);
            int c2= findLPSLength_Recursive(str,si,ei-1);
            return Math.max(c1,c2);
        }

    }
}
