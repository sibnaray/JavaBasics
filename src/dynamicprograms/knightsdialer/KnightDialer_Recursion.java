package dynamicprograms.knightsdialer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightDialer_Recursion {
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
        System.out.println(countPhoneNumHelper(3,1));
    }

    static int countPhoneNumHelper(int hopsLeft, int pos){
        if(hopsLeft == 0)
            return 0;
        if(hopsLeft == 1){
            System.out.println(hopsLeft+" " +pos);
            return 1;
        }

        int count = 0;
        int[] neigh = moves.get(pos);
        for(int i = 0;i<neigh.length;i++){
            count = count + countPhoneNumHelper(hopsLeft-1,neigh[i]);
            System.out.println(hopsLeft+" " +pos+" "+count);
        }
        return count;
    }
}
