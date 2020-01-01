package dynamicprograms;

public class Game_PickingBagOfMoneyFromLeftOrRight {
    //Can take money from beginning or end and then the opponent takes. First move is ours.


    //Player 1 Option 1 : 8 + 4  = 12
    //Player 1 Option 2 : 3 + 10 = 13

    //game(l,r) = max{
    //                  bag[l] + min{
    //                              game(l+2,r), -- opponent took from left
    //                              game(l+1,r-1) -- opponent took from right
    //                           },
    //                  bag[r] + min{
    //                              game(l+1,r-1),  -- opponent took from left
    //                              game(l,r-2) -- opponent took from right
    //                          }
    //          } -- checking MIN because opponent is trying to minimize our score.

    //since 2 value determines the end point it's 2D.
    // 8 10 4 3

    //                   Left Index
    // Remaining bags    0      1       2       3
    //             1     8      10      12      13
    //             2     0      10      10      13
    //             3     0      0       4       4
    //             4     0      0       0       3
    // '-' cases where no of bags left greater than elements left in array

    // base case is when remaining bag is 1 or 2
    public static void main(String[] args) {
        int[] bags = new int[]{8,10,4,3};
        System.out.println(game(bags));
    }

    static int game(int[] bags){
        int numOfBag = bags.length;
        int[][] dp = new int[numOfBag][numOfBag];

        for(int remainingBags = 1;remainingBags<=numOfBag;remainingBags++){
            for(int lmi = 0;lmi<=numOfBag-remainingBags;lmi++){
                int rmi = lmi + remainingBags - 1;
                if(remainingBags == 1)
                    dp[lmi][rmi] = bags[lmi];
                else if(remainingBags == 2)
                    dp[lmi][rmi] = Math.max(bags[lmi], bags[lmi+1]);
                else{
                    dp[lmi][rmi] = Math.max(bags[lmi]
                                                    + Math.min(dp[lmi+1][rmi-1],dp[lmi+2][rmi]),
                                                bags[rmi]
                                                    + Math.min(dp[lmi+1][rmi-1],dp[lmi][rmi-2]));
                }
            }
        }
        for(int i = 0 ; i< numOfBag;i++){
            for(int j = 0;j<numOfBag;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return dp[0][numOfBag-1];
    }
}
