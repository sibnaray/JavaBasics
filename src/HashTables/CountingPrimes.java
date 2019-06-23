package HashTables;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountingPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(
                1500000));
    }
    public static int countPrimes(int n){
        if(n<=2)
            return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=2 ; i*i <n; i++){
            if(set.contains(i)) continue;
            for(int j=i*i; j<n ; j+=i){
                set.add(j);
            }
        }
        return n-(set.size()+2);
    }
}
