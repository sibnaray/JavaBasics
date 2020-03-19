package dynamicprograms.longestcommonsubstring;

// 1) If the character at the strIndex (in the string) matches the character at patIndex (in the pattern),
// the count of the SPM would be equal to the count of SPM up to strIndex-1 and patIndex-1.
// 2) At every step, we can always skip a character from the string to try matching the remaining string with the pattern;
// therefore, we can add the SPM count from the indexes strIndex-1 and patIndex.

//if str[strIndex] == pat[patIndex] {
//  dp[strIndex][patIndex] = dp[strIndex-1][patIndex-1]
//}
//dp[i1][i2] += dp[strIndex-1][patIndex]


public class SubsequencePatternMatchingCount_BU_Tabulation {
    public static void main(String[] args) {
        SubsequencePatternMatchingCount_BU_Tabulation spm = new SubsequencePatternMatchingCount_BU_Tabulation();
        System.out.println(spm.findSPMCount("baxmx", "ax"));
        System.out.println(spm.findSPMCount("tomorrow", "tor"));
    }

    int findSPMCount(String str, String pat){
        if(pat.length()==0)
            return 1;
        if(str.length()==0 || pat.length() > str.length())
            return 0;
        int[][] dp = new int[str.length()+1][pat.length()+1];

        // for the empty pattern, we have one matching
        for(int i=0; i<=str.length(); i++)
            dp[i][0] = 1;

        for(int strIndex=1;strIndex<=str.length();strIndex++){
            for(int patIndex=1;patIndex<=pat.length();patIndex++){
                if(str.charAt(strIndex-1)==pat.charAt(patIndex-1))
                    dp[strIndex][patIndex] = dp[strIndex-1][patIndex-1];
                dp[strIndex][patIndex]+=dp[strIndex-1][patIndex];
            }
        }
        return  dp[str.length()][pat.length()];
    }
}
