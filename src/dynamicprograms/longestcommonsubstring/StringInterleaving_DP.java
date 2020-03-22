package dynamicprograms.longestcommonsubstring;

//Give three strings ‘m’, ‘n’, and ‘p’, write a method to find out if ‘p’ has been formed by interleaving ‘m’ and ‘n’.
// ‘p’ would be considered interleaving ‘m’ and ‘n’ if it contains all the letters from ‘m’ and ‘n’ and the order
// of letters is preserved too.

//Input: m="abd", n="cef", p="abcdef"
//Output: true
//Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.

//Input: m="abd", n="cef", p="adcbef"
//Output: false
//Explanation: 'p' contains all the letters from 'm' and 'n' but does not preserve the order.

//Input: m="abc", n="def", p="abdccf"
//Output: false
//Explanation: 'p' does not contain all the letters from 'm' and 'n'.

//Input: m="abcdef", n="mnop", p="mnaobcdepf"
//Output: true
//Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.

//If the character m[mIndex] matches the character p[pIndex], we will take the matching result up to mIndex-1 and nIndex.
//If the character n[nIndex] matches the character p[pIndex], we will take the matching result up to mIndex and nIndex-1.


//dp[mIndex][nIndex] = false
//if m[mIndex] == p[pIndex]
//  dp[mIndex][nIndex] = dp[mIndex-1][nIndex]
//if n[nIndex] == p[pIndex]
// dp[mIndex][nIndex] |= dp[mIndex][nIndex-1]

public class StringInterleaving_DP {
    public static void main(String[] args) {
        StringInterleaving_DP si = new StringInterleaving_DP();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    }

    boolean findSI(String s1, String s2, String s3){

        // for the empty pattern, we have one matching
        if(s1.length() + s2.length() != s3.length())
            return false;

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        for(int s1_i=0;s1_i<=s1.length();s1_i++){
            for(int s2_i=0;s2_i<=s2.length();s2_i++){
                if(s1_i==0 && s2_i==0)
                    dp[s1_i][s2_i]=true;
                else if(s1_i==0 && s2.charAt(s2_i-1)==s3.charAt(s2_i-1))
                    dp[0][s2_i]=true;
                else if(s2_i==0 && s1.charAt(s1_i-1)==s3.charAt(s1_i-1))
                    dp[s1_i][0]=true;
                else{
                    if(s1_i>0 && s1.charAt(s1_i-1)==s3.charAt(s1_i+s2_i-1))
                        dp[s1_i][s2_i]=dp[s1_i-1][s2_i];
                    if(s2_i>0 && s2.charAt(s2_i-1)==s3.charAt(s1_i+s2_i-1))
                        dp[s1_i][s2_i] |= dp[s1_i][s2_i-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
