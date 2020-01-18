package dynamicprograms.unboundedknapsack;

//Given a number array to represent different coin denominations and a total amount ‘T’, we need to find all the different
//        ways to make a change for ‘T’ with the given coin denominations. We can assume an infinite supply of coins,
//        therefore, each coin can be chosen multiple times.
//This problem is quite similar to Count of Subset Sum. The only difference here is that after including the item (i.e. coin),
//        we recursively call to process all the items (including the current coin).
//        In ‘Count of Subset Sum’, however, we were recursively calling to process only the remaining items.
public class CoinChange_Recursive {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        System.out.println(countChange(denominations, 5));
    }

    static int countChange(int[] denomination, int amount){
        return countChangeRecursive(denomination,amount,0);
    }

    static int countChangeRecursive(int[] denomination,int amount, int currentIndex){
        if(amount==0)
            return 1;

        if(denomination.length==0 || currentIndex >= denomination.length )
            return 0;

        //Calculate including element if element less than amount. by not increasing currentIndex
        //so taht we can include again
        int total1=0;
        if(denomination[currentIndex] <= amount){
            total1 = countChangeRecursive(denomination,amount-denomination[currentIndex], currentIndex);
        }

        //Calculate without element
        int total2=0;
        total2 = countChangeRecursive(denomination,amount,currentIndex+1);

        return total1 + total2;
        }
}
