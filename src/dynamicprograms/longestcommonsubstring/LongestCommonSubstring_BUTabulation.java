package dynamicprograms.longestcommonsubstring;
//Given two strings ‘s1’ and ‘s2’, find the length of the longest substring which is common in both the strings.
//Input: s1 = "abdca"
//       s2 = "cbda"
//Output: 2
//Explanation: The longest common substring is "bd".

//Input: s1 = "passport"
//       s2 = "ppsspt"
//Output: 3
//Explanation: The longest common substring is "ssp".
public class LongestCommonSubstring_BUTabulation {
    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }

    static int findLCSLength(String str1, String str2){
        int[][] dp = new int [str1.length()+1][str2.length()+1];
        int maxLength = 0;
        for(int i1=1;i1<=str1.length();i1++){
            for(int i2=1;i2<=str2.length();i2++) {
                if(str1.charAt(i1-1) == str2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                    maxLength = Math.max(maxLength, dp[i1][i2]);
                }
            }
        }
        return maxLength;
    }
}
