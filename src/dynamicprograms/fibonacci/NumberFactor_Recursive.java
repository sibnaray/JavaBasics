package dynamicprograms.fibonacci;

//Given a number ‘n’, implement a method to count how many possible ways there are
// to express ‘n’ as the sum of 1, 3, or 4.
//n : 4
//Number of ways = 4
//Explanation: Following are the four ways we can exoress 'n' : {1,1,1,1}, {1,3}, {3,1}, {4}
//n : 5
//Number of ways = 6
//Explanation: Following are the six ways we can express 'n' : {1,1,1,1,1}, {1,1,3}, {1,3,1}, {3,1,1},
//{1,4}, {4,1}
public class NumberFactor_Recursive {
    public static void main(String[] args) {
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(6));
    }

    static int countWays(int n){
        if(n==0)
            return 1;
        if(n==1)
            return 1;// (1)
        if(n == 2)
            return 1;//(1 + 1)
        if(n == 3)
            return 2;//(1 + 1 + 1), (3)

        int count1 = countWays(n - 1);
        int count3 = countWays(n - 3);
        int count4 = countWays(n - 4);

        return count1 + count3 + count4;
    }
}
