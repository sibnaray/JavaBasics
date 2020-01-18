package dynamicprograms.fibonacci;

import java.util.Arrays;

public class TripleStairsTopDownMemoize {
    public static void main(String[] args) {
        System.out.println(countWays(3));
        System.out.println(countWays(4));
        System.out.println(countWays(5));
    }

    static int countWays(int stepsToclimb){
        int[]  waysToClimp = new int[stepsToclimb + 1];
        Arrays.fill(waysToClimp,-1);
        return tripleStairsTDMomoizationHelper(waysToClimp, stepsToclimb);
    }
    public static int tripleStairsTDMomoizationHelper(int[] waysToClimp, int stepsToclimb){
       if(stepsToclimb < 0)
           return 0;
       if(stepsToclimb == 0)
           return 1;
       if(waysToClimp[stepsToclimb] == -1){
           waysToClimp[stepsToclimb] = tripleStairsTDMomoizationHelper(waysToClimp,stepsToclimb-1)
                   + tripleStairsTDMomoizationHelper(waysToClimp, stepsToclimb - 2)
                   + tripleStairsTDMomoizationHelper(waysToClimp, stepsToclimb - 3);
       }
       return waysToClimp[stepsToclimb];
    }
}
