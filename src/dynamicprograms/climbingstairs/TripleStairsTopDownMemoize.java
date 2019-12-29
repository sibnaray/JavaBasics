package dynamicprograms.climbingstairs;

public class TripleStairsTopDownMemoize {
    public static void main(String[] args) {
        int[] waysToClimp = new int[5+1];
        for(int i = 0;i<=5;i++){
            waysToClimp[i]=-1;
        }
        System.out.println("Ways to climp 5 stairs : "+ tripleStairsTDMomoizationHelper(waysToClimp,5));
    }
    public static int tripleStairsTDMomoizationHelper(int[] waysToClimp, int stepsToclimb){
        if(stepsToclimb < 0)
            return 0;
        else if(stepsToclimb == 0 )
            return 1;
        else{
            if(waysToClimp[stepsToclimb] != -1)
                return waysToClimp[stepsToclimb];
            else{
                waysToClimp[stepsToclimb] = tripleStairsTDMomoizationHelper(waysToClimp,stepsToclimb-1)
                        + tripleStairsTDMomoizationHelper(waysToClimp,stepsToclimb-2)
                        + tripleStairsTDMomoizationHelper(waysToClimp,stepsToclimb-3);
                return waysToClimp[stepsToclimb];
            }
        }
    }
}
