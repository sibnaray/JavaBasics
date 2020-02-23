package dynamicprograms.longestcommonsubstring;

//Given two strings ‘s1’ and ‘s2’, find the length of the longest subsequence which is common in both the strings.
//
//A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
// changing the order of the remaining elements.

//If the character s1[i] matches s2[j], we can recursively match for the remaining lengths.
//If the character s1[i] does not match s2[j], we will start two new recursive calls by skipping
// one character separately from each string.

//Input: s1 = "abdca"
//       s2 = "cbda"
//Output: 3
//Explanation: The longest common subsequence is "bda".

//Input: s1 = "passport"
//       s2 = "ppsspt"
//Output: 5
//Explanation: The longest common subsequence is "psspt".

public class LongestCommonSubsequence_Recusrion {
    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }

    static int findLCSLength(String str1, String str2){
        return findLCSLength_Rec(str1, str2, 0, 0);
    }

    static int findLCSLength_Rec(String str1, String str2, int i1, int i2){
        if(i1==str1.length() || i2 == str2.length())
            return 0;

        if(str1.charAt(i1) == str2.charAt(i2))
            return 1 + findLCSLength_Rec(str1,str2,i1+1, i2+1);

        int c1 = findLCSLength_Rec(str1,str2,i1+1,i2);
        int c2 = findLCSLength_Rec(str1,str2, i1, i2+1);

        return Math.max(c1, c2);
    }
}
