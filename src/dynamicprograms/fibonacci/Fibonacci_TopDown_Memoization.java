package dynamicprograms.fibonacci;

public class Fibonacci_TopDown_Memoization {
    public int calculateFibonacci(int n){
        int memonize[] = new int[n+1];
        return calculateAnsMemonizeFibonacci(memonize,n);
    }

    public int calculateAnsMemonizeFibonacci(int[] memonize, int n){
        if(n < 2)
            return n;

        // if we have already solved this sub-problem, simply return the result from the cache
        if(memonize[n] != 0)
            return memonize[n];

        memonize[n]=calculateAnsMemonizeFibonacci(memonize,n-1) + calculateAnsMemonizeFibonacci(memonize,n-2);
        return memonize[n];
    }

    public static void main(String[] args) {
        Fibonacci_TopDown_Memoization fibonacci_topDown_memoization = new Fibonacci_TopDown_Memoization();
        System.out.println("5th Fibonacci is ---> " + fibonacci_topDown_memoization.calculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fibonacci_topDown_memoization.calculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fibonacci_topDown_memoization.calculateFibonacci(7));
    }
}
