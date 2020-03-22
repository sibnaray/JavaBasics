package dynamicprograms.longestcommonsubstring;

//If the character s1[i1] matches s2[i2], the count of the edit operations will be equal to
// the count of the edit operations for the remaining strings.
//If the character s1[i1] does not match s2[i2], we will take the minimum count from the
// remaining strings after performing any of the three edit operations.


public class EditDistance_DP {
    public static void main(String[] args) {
        EditDistance_DP editDisatnce = new EditDistance_DP();
        System.out.println(editDisatnce.findMinOperations("bat", "but"));
        System.out.println(editDisatnce.findMinOperations("abdca", "cbda"));
        System.out.println(editDisatnce.findMinOperations("passpot", "ppsspqrt"));
    }

    int findMinOperations(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++)
            dp[i][0]=i;
        for(int j=0;j<=str2.length();j++)
            dp[0][j]=j;

        for(int i1=1;i1<=str1.length();i1++){
            for(int i2=1;i2<=str2.length();i2++){
                if(str1.charAt(i1-1)==str2.charAt(i2-1))
                    dp[i1][i2]=dp[i1-1][i2-1];
                else
                    dp[i1][i2]=1+Math.min(dp[i1-1][i2],Math.min(dp[i1][i2-1],dp[i1-1][i2-1]));
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
