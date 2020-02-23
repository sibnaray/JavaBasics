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
public class LongestCommonSubstring_TDMemoization {
    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }

    static int findLCSLength(String str1, String str2){
        //The three changing values to our recursive function are the two indexes (i1 and i2) and the ‘count’.
        // Therefore, we can store the results of all subproblems in a three-dimensional array.
        // (Another alternative could be to use a hash-table whose key would be a string (i1 + “|” i2 + “|” + count)).
        int maxLength=Math.min(str1.length(), str2.length());
        Integer[][][] dp= new Integer[str1.length()][str2.length()][maxLength];
        return findLCSLength_TDMemoization(dp,str1,str2,0,0,0);
    }

    static int findLCSLength_TDMemoization(Integer[][][] dp, String str1, String str2, int si1, int si2, int count){
        if(si1==str1.length() || si2 == str2.length())
            return count;

        if(dp[si1][si2][count] == null){
            int c1 = count;
            if(str1.charAt(si1) == str2.charAt(si2))
                c1 = findLCSLength_TDMemoization(dp,str1,str2,si1+1,si2+1,count+1);
            int c2 = findLCSLength_TDMemoization(dp,str1,str2, si1+1, si2, 0);
            int c3 = findLCSLength_TDMemoization(dp,str1, str2, si1,si2+1,0);
            dp[si1][si2][count]=Math.max(c1,Math.max(c2,c3));
        }
        return dp[si1][si2][count];
    }
}
