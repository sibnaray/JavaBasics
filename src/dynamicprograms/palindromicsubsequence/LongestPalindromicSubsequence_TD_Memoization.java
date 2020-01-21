package dynamicprograms.palindromicsubsequence;

public class LongestPalindromicSubsequence_TD_Memoization {
    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }

    static int findLPSLength(String str){
        Integer[][] dp = new Integer[str.length()][str.length()];
        return findLPSLength_TD(dp,str,0,str.length()-1);
    }

    static int findLPSLength_TD(Integer[][] dp, String str, int si, int ei){
        if(si > ei)
            return 0;
        if(si ==  ei)
            return 1;

        if(dp[si][ei] == null){
            if(str.charAt(si) == str.charAt(ei))
                dp[si][ei] = 2 + findLPSLength_TD(dp,str,si+1,ei-1);
            else{
                int c1 = findLPSLength_TD(dp,str,si+1,ei);
                int c2 = findLPSLength_TD(dp,str,si,ei-1);
                dp[si][ei] = Math.max(c1,c2);
            }
        }
        return dp[si][ei];
    }
}
