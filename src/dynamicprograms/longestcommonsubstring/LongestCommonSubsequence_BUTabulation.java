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
public class LongestCommonSubsequence_BUTabulation {

    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }

    static int findLCSLength(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+2];

        for(int i1=1;i1<=str1.length();i1++){
            for(int i2=1;i2<=str2.length();i2++){
                if(str1.charAt(i1-1) == str2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                }else{
                    dp[i1][i2] = Math.max(dp[i1-1][i2],dp[i1][i2-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
