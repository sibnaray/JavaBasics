package dynamicprograms.longestcommonsubstring;

public class ShortestCommonSuperSequence_TD_Memoization {
    public static void main(String[] args) {
        ShortestCommonSuperSequence_TD_Memoization scs = new ShortestCommonSuperSequence_TD_Memoization();
        System.out.println(scs.findSCSLength("abcf", "bdcf"));
        System.out.println(scs.findSCSLength("dynamic", "programming"));
    }

    private int findSCSLength(String str1, String str2){
        Integer[][] dp = new Integer[str1.length()][str2.length()];
        return findSCSLength_TD_Mem(dp,str1,str2,0, 0);
    }

    private int findSCSLength_TD_Mem(Integer[][] dp, String str1, String str2, int str1_i, int str2_i){
        if(str1_i == str1.length())
            return str2.length()-str2_i;

        if(str2_i == str2.length())
            return str1.length() - str1_i;

        if(dp[str1_i][str2_i]==null){
            if(str1.charAt(str1_i) == str2.charAt(str2_i))
                dp[str1_i][str2_i] = 1 + findSCSLength_TD_Mem(dp,str1,str2,str1_i+1, str2_i+1);
            else{
                int length1 = 1+ findSCSLength_TD_Mem(dp,str1,str2,str1_i+1, str2_i);
                int length2 = 1+ findSCSLength_TD_Mem(dp,str1,str2,str1_i, str2_i+1);
                dp[str1_i][str2_i] = Math.min(length1,length2);
            }
        }
        return dp[str1_i][str2_i];
    }
}
