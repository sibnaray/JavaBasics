package dynamicprograms.longestcommonsubstring;

//Given a sequence, find the length of its longest repeating subsequence (LRS).
// A repeating subsequence will be the one that appears at least twice in the original sequence
// and is not overlapping (i.e. none of the corresponding characters in the repeating subsequences have the same index).

//Input: “t o m o r r o w”
//Output: 2
//Explanation: The longest repeating subsequence is “or” {tomorrow}.

//Input: “a a b d b c e c”
//Output: 3
//Explanation: The longest repeating subsequence is “a b c” {a a b d b c e c}.

//Input: “f m f f”
//Output: 2
//Explanation: The longest repeating subsequence is “f f” {f m f f, f m f f}.
// Please note the second last character is shared in LRS.

public class LongestRepeatingSubsequence_Rec {
    public static void main(String[] args) {
        LongestRepeatingSubsequence_Rec lrs = new LongestRepeatingSubsequence_Rec();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));
    }

    int findLRSLength(String str){
        return findLRSLength_Rec(str, 0,0);
    }

    int findLRSLength_Rec(String str, int i1, int i2){
        if(i1==str.length() || i2==str.length())
            return 0;
        if(i1!=i2 && str.charAt(i1)==str.charAt(i2))
            return 1 + findLRSLength_Rec(str,i1+1, i2+1);

        int c1 = findLRSLength_Rec(str,i1+1, i2);
        int c2 = findLRSLength_Rec(str, i1, i2+1);
        return Math.max(c1, c2);
    }
}
