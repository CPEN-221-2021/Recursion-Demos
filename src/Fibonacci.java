import java.util.*;

/**
 * This class ...
 *
 * @author Mohammad Shahrad
 */

public class Fibonacci {
    private Map <Integer, Long> cache = new HashMap<>();

    public Fibonacci (){
        int[] inputsToTest = new int[]{8, 32, 43};
        for (int input : inputsToTest){
            long output;
            long startTime;
            long endTime;

            startTime = System.nanoTime();
            output = RunFibonacci(input);
            endTime = System.nanoTime();
            System.out.println( "RunFibonacci("+input+") = "+output+", duration (us): "+(endTime-startTime)/1000 );

            startTime = System.nanoTime();
            output = RunFibonacciRecursive(input);
            endTime = System.nanoTime();
            System.out.println( "RunFibonacciRecursive("+input+") = "+output+", duration (us): "+(endTime-startTime)/1000 );

            startTime = System.nanoTime();
            output = RunFibonacciRecursiveMem(input);
            endTime = System.nanoTime();
            System.out.println( "RunFibonacciRecursiveDP("+input+") = "+output+", duration (us): "+(endTime-startTime)/1000 );

            startTime = System.nanoTime();
            output = RunFibonacciRecursiveMem(input);
            endTime = System.nanoTime();
            System.out.println( "2nd RunFibonacciRecursiveDP("+input+") = "+output+", duration (us): "+(endTime-startTime)/1000 );

            cache.clear();
            System.out.println( "------------------------------" );
        }
    }

    public long RunFibonacciRecursive (int n){
        if (n==0){              // base case for n=0
            return 0;
        } else if (n==1) {      // base case for n=1
            return 1;
        } else {                // recursive step
            return RunFibonacciRecursive(n-1) + RunFibonacciRecursive(n-2);
        }
    }

    public long RunFibonacci (int n){
        if (n==0){
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            long n_1 = 1;
            long n_2 = 0;
            long sum = 0;
            for (int i=2; i<=n; i++){
                sum = n_1 + n_2;
                n_2 = n_1;
                n_1 = sum;
            }
            return sum;
        }
    }

    public long RunFibonacciRecursiveMem (int n){
        if (cache.containsKey(n)){  // check if we had calculated it before
            return cache.get(n);
        }
        if (n==0){                  // base case for n=0
            cache.put(0, 0L);
            return 0;
        } else if (n==1) {          // base case for n=1
            cache.put(1, 1L);
            return 1;
        } else {                    // recursive step
            long result = RunFibonacciRecursive(n-1) + RunFibonacciRecursive(n-2);
            cache.put(n, result);
            return result;
        }
    }
}
