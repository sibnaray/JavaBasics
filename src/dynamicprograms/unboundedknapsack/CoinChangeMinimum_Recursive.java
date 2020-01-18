package dynamicprograms.unboundedknapsack;

//Given a number array to represent different coin denominations and a total amount ‘T’, we need to find the
//        minimum number of coins needed to make change for ‘T’. We can assume an infinite supply of coins,
//        therefore, each coin can be chosen multiple times.



public class CoinChangeMinimum_Recursive {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
//        System.out.println(countChange(denominations, 5));
//        System.out.println(countChange(denominations, 11));
//        System.out.println(countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(countChange(denominations, 7));
    }

    static int countChange(int[] denominations, int totalAmount){
        int result =  countChangeRecursive(denominations, totalAmount, 0);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    static int countChangeRecursive(int[] denominations, int totalAmount, int currentIndex){
        if(totalAmount == 0)
            return 0;

        if(denominations.length == 0 || currentIndex >= denominations.length)
            return Integer.MAX_VALUE;

        int count1 = Integer.MAX_VALUE;
        if(denominations[currentIndex] <= totalAmount){
            int res = countChangeRecursive(denominations,totalAmount-denominations[currentIndex],currentIndex);
            if(res!=Integer.MAX_VALUE)
            count1 =res + 1;
        }

        int count2 = countChangeRecursive(denominations,totalAmount,currentIndex+1);

        return Math.min(count1,count2);
    }
}
