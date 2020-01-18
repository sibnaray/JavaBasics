package dynamicprograms.unboundedknapsack;

public class RibbonCutMaximumPieces_BU_Tabulation {
    public static void main(String[] args) {
        int[] ribbonLengths = {2,3,5};
        System.out.println(countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{3,5,7};
        System.out.println(countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(countRibbonPieces(ribbonLengths, 7));
    }
    static int countRibbonPieces(int[] ribbonLengths, int totLen){
        int n = ribbonLengths.length;
        int[][] dp = new int[n][totLen+1];

        for(int i=0; i < n; i++)
        for(int j=0; j <= totLen; j++)
            dp[i][j] = Integer.MIN_VALUE;

        for(int i = 0;i <n;i++)
            dp[i][0]=0;

        for(int i = 0 ; i<n ; i++){
            for(int l = 1; l <= totLen; l++){
                if(ribbonLengths[i] <= l && dp[i][l-ribbonLengths[i]] != Integer.MIN_VALUE){
                    //include item
                    dp[i][l] = dp[i][l-ribbonLengths[i]] + 1;
                }

                //find max if included and excluded
                if(i > 0)
                    dp[i][l] = Math.max(dp[i-1][l], dp[i][l]);
            }
        }
        return Integer.MIN_VALUE == dp[n-1][totLen] ? -1 : dp[n-1][totLen];
    }
}
