package dynamicprograms;

//Sample
//Length: 1 | 2 | 3 | 4
//Profit: 2 | 5 | 6 | 11

public class MaximumProfit_CuttingGoldRode {
    static class MaximumProfits{
        int length;
        int profit;
         public MaximumProfits(int length, int profit){
             this.length=length;
             this.profit=profit;
         }
    }
    public static void main(String[] args) {
        MaximumProfits[] profits = new MaximumProfits[4];
        profits[0]= new MaximumProfits(1,2);
        profits[1]= new MaximumProfits(2,5);
        profits[2]= new MaximumProfits(3, 6);
        profits[3]= new MaximumProfits(4,11);
        System.out.println(getMaximunProfit(6,profits));
    }
    static int getMaximunProfit(int L,MaximumProfits[] mps){
        ////DP table as below
        //Rod Length : 0 | 1 | 2 | 3 | 4 | 5 | 6
        //Profits    : 0 | 2 | 5 | 7 | 11| 13| 16
        int[] dp = new int[L+1];
        dp[0]=0;
        for(int l=1;l<=L;l++){
            for(MaximumProfits mp : mps){
                if(mp.length>l)
                    continue;
                int newMP = dp[l-mp.length] + mp.profit;
                if(newMP > dp[l])
                    dp[l] = newMP;
            }
        }
        return dp[L];
    }
}
