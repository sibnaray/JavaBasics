package dynamicprograms.unboundedknapsack;

//Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which
//will give us maximum profit such that their cumulative weight is not more than a given number ‘C’.
//We can assume an infinite supply of item quantities; therefore, each item can be selected multiple times.
//The only difference between the 0/1 Knapsack problem and this one is that, after including the item,
// we recursively call to process all the items (including the current item). In 0/1 Knapsack, however,
// we recursively call to process the remaining items.
public class UnboundedKnapsack_Recursion {
    public static void main(String[] args) {
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }

    static int solveKnapsack(int[] profits, int[] weights,int capacity){
        return solveKnapsackRecursion(profits,weights,capacity,0);
    }

    static int solveKnapsackRecursion(int[] profits, int[] weights,int capacity,int currentIndex){
        if(capacity<=0 || profits.length == 0 || profits.length!=weights.length || currentIndex >= profits.length)
            return 0;

        int profit1 = 0;
        if(weights[currentIndex] <= capacity) {
            // recursive call after choosing the items at the currentIndex, note that we recursive call on all
            // items as we did not increment currentIndex
            profit1 = profits[currentIndex] + solveKnapsackRecursion(profits, weights,
                    capacity - weights[currentIndex], currentIndex);
        }
        int profit2 = 0;
        // recursive call after excluding the element at the currentIndex
        profit2 = solveKnapsackRecursion(profits,weights,capacity,currentIndex+1);

        return Math.max(profit1,profit2);
    }
}
