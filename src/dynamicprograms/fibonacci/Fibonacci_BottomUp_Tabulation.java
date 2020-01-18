package dynamicprograms.fibonacci;

public class Fibonacci_BottomUp_Tabulation {
    public static void main(String[] args) {
        System.out.println("5th Fibonacci is ---> " + calculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + calculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + calculateFibonacci(7));
    }

    static int calculateFibonacci(int n){
        if(n < 2)
            return n;
        int[] dp = new int[n+1];
        for(int i = 0;i<=n;i++){
            if(i==0)
                dp[i] = 0;
            else if(i==1)
                dp[i] = 1;
            else
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
