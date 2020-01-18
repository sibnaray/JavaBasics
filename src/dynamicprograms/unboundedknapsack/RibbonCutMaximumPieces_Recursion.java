package dynamicprograms.unboundedknapsack;

//Given a number array to represent possible ribbon lengths and a total ribbon length ‘n’, 
// we need to find the maximum number of pieces that the ribbon can be cut into.

//This problem follows the Unbounded Knapsack pattern and is quite similar to Minimum Coin Change (MCC). 
// The only difference is that in MCC we were asked to find the minimum number of coin changes, 
// whereas in this problem we need to find the maximum number of pieces.

public class RibbonCutMaximumPieces_Recursion {
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
        int result = countRibbonPieces_Recursive(ribbonLengths,totLen,0);
        return result==Integer.MIN_VALUE ? -1 : result;
    }

    static int countRibbonPieces_Recursive(int[] ribbonLengths,int totLen, int currentIndex){
        if(totLen == 0)
            return 0;
        int n = ribbonLengths.length;
        if( n == 0 || currentIndex >= n){
            return Integer.MIN_VALUE;
        }
        int count1=Integer.MIN_VALUE;
        if(ribbonLengths[currentIndex]<=totLen){
            int res = countRibbonPieces_Recursive(ribbonLengths,totLen-ribbonLengths[currentIndex],currentIndex);
            if(res != Integer.MIN_VALUE)
                count1 = 1 + res ;
        }

        int count2 = countRibbonPieces_Recursive(ribbonLengths,totLen,currentIndex+1);
        return Math.max(count1,count2);
    }
}
