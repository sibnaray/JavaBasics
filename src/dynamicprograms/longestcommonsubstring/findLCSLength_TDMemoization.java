package dynamicprograms.longestcommonsubstring;

import javax.swing.*;

public class LongestCommonSubsequence_TDMemoization {
    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }

    static int findLCSLength(String str1, String str2){
        Integer[][] dp = new Integer[str1.length()][str2.length()];
        return findLCSLength_TDMemoization(dp, str1,str2,0,0);
    }

    static int findLCSLength_TDMemoization(Integer[][] dp, String str1, String str2, int i1, int i2){
        if(i1==str1.length() || i2==str2.length())
            return 0;

        if(dp[i1][i2] == null){
            if(str1.charAt(i1) == str2.charAt(i2))
                dp[i1][i2] = 1 + findLCSLength_TDMemoization(dp, str1, str2, i1+1, i2+1);
            else{
                int c1 = findLCSLength_TDMemoization(dp, str1, str2, i1+1, i2);
                int c2 = findLCSLength_TDMemoization(dp, str1, str2, i1, i2+1);
                dp[i1][i2] = Math.max(c1,c2);
            }
        }
        return dp[i1][i2];
    }
}
