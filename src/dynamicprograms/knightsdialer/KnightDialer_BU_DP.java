package dynamicprograms.knightsdialer;

import java.util.HashMap;
import java.util.Map;

public class KnightDialer_BU_DP {
    static Map<Integer, int[]> moves = new HashMap<>();
    static{
        moves.put(0, new int[]{4,6});
        moves.put(1,new int[]{8,6});
        moves.put(2,new int[]{9,7});
        moves.put(3, new int[]{4,8});
        moves.put(4,new int[]{3,9,0});
        moves.put(5,new int[]{});
        moves.put(6,new int[]{1,7,0});
        moves.put(7,new int[]{6,2});
        moves.put(8,new int[]{1,3});
        moves.put(9,new int[]{2,4});
    }

    public static void main(String[] args) {
        System.out.println(numPhoneNumbers(6,30));
    }

    static long numPhoneNumbers(int startdigit, int phonenumberlength) {
        long[][] dp = new long[phonenumberlength+1][10];
        for(int i=0;i<=phonenumberlength;i++){
            for(int j=0;j<10;j++){
                dp[i][j]=0;
            }
        }
        return countPhoneNumHelper(dp,phonenumberlength,startdigit);
    }

    static long countPhoneNumHelper(long[][] dp, int hops,int pos){
        for(int j = 1 ; j <=hops;j++){
            for(int i = 0; i<10;i++){
                if(j==1)
                    dp[j][i] = 1;
                else{
                    int[] Neigh =  moves.get(i);
                    for(int n : Neigh){
                        dp[j][i] = dp[j][i] + dp[j-1][n];
                    }
                }
            }
        }
        System.out.println(dp[hops][pos]);
        return dp[hops][pos];
    }
}
