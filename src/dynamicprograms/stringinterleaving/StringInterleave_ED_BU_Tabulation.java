package dynamicprograms.stringinterleaving;

//As mentioned above, we will be tracking separate indexes for ‘m’, ‘n’ and ‘p’,
// so we will have the following options for every value of mIndex, nIndex, and pIndex:
//
//If the character m[mIndex] matches the character p[pIndex], we will take the matching result up to mIndex-1 and nIndex.
//If the character n[nIndex] matches the character p[pIndex], we will take the matching result up to mIndex and nIndex-1.
//String ‘p’ will be interleaving strings ‘m’ and ‘n’ if any of the above two options is true.
// This is also required as there could be some common letters between ‘m’ and ‘n’.

//dp[mIndex][nIndex] = false
//if m[mIndex] == p[pIndex]
//  dp[mIndex][nIndex] = dp[mIndex-1][nIndex]
//if n[nIndex] == p[pIndex]
// dp[mIndex][nIndex] |= dp[mIndex][nIndex-1]

public class StringInterleave_ED_BU_Tabulation {
    public static void main(String[] args) {
        StringInterleave_ED_BU_Tabulation si = new StringInterleave_ED_BU_Tabulation();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    }

    Boolean findSI(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        for(int s1_Index=0;s1_Index<=s1.length(); s1_Index++){
            for(int s2_Index=0; s2_Index<=s2.length(); s2_Index++){
                // if 'm' and 'n' are empty, then 'p' must have been empty too.
                if(s1_Index==0 && s2_Index==0)
                    dp[s1_Index][s2_Index] = true;
                else if(s1_Index==0 && s2.charAt(s2_Index-1) == s3.charAt(s1_Index + s2_Index -1))
                    dp[s1_Index][s2_Index] = dp[s1_Index][s2_Index-1];
                else if(s2_Index == 0 && s1.charAt(s1_Index-1) == s3.charAt(s1_Index+s2_Index-1))
                    dp[s1_Index][s2_Index] = dp[s1_Index-1][s2_Index];
                else{
                    if(s1_Index>0 && s1.charAt(s1_Index-1)==s3.charAt(s1_Index+s2_Index-1))
                        dp[s1_Index][s2_Index] = dp[s1_Index-1][s2_Index];

                    if(s2_Index >0 && s2.charAt(s2_Index-1)==s3.charAt(s1_Index+s2_Index-1))
                        dp[s1_Index][s2_Index] = dp[s1_Index][s2_Index-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
