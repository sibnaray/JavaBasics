package dynamicprograms.fibonacci;

public class Fibonacci_Recursive {
    public static void main(String[] args) {
        Fibonacci_Recursive fibonacciRecursive = new Fibonacci_Recursive();
        System.out.println("5th Fibonacci is ---> " + fibonacciRecursive.calculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fibonacciRecursive.calculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fibonacciRecursive.calculateFibonacci(7));
    }

    public int calculateFibonacci(int n){
        if(n < 2)
            return n;
        return calculateFibonacci(n-2) + calculateFibonacci(n-1);
    }
}

