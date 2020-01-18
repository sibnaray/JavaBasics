package dynamicprograms.unboundedknapsack;

public class RibbonCutMaximumPieces_TD_Memoization {
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
        Integer[][] dp = new Integer[ribbonLengths.length][totLen+1];
        int res = countRibbonPieces_TD(dp,ribbonLengths,totLen,0);
        return res==Integer.MIN_VALUE ? -1 : res;
    }

    static int countRibbonPieces_TD(Integer[][] dp,int[] ribbonLengths, int totLen, int currentIndex){
        if(totLen == 0)
            return 0;

        if(ribbonLengths.length==0 || currentIndex >= ribbonLengths.length)
            return Integer.MIN_VALUE;

        if(dp[currentIndex][totLen] == null){
            int count1=Integer.MIN_VALUE;
            if(ribbonLengths[currentIndex] <= totLen){
                int res = countRibbonPieces_TD(dp,ribbonLengths,totLen-ribbonLengths[currentIndex], currentIndex);
                if(res != Integer.MIN_VALUE)
                    count1 = 1 + res;
            }
            int count2 = countRibbonPieces_TD(dp,ribbonLengths,totLen,currentIndex+1);
            dp[currentIndex][totLen] = Math.max(count1,count2);
        }
        return dp[currentIndex][totLen];
    }
}
