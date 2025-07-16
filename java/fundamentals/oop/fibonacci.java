package fundamentals.oop;

import java.util.Arrays;

public class fibonacci {
    public void returnAll(int n) {
        int[] fibonacciArray = new int[n];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacciArray[i] = fibonacciArray[i-1] + fibonacciArray[i-2];
        }
        System.out.println("The First " + n + " numbers in the fibonacci sequence are: \n");
        for (int number: fibonacciArray) {
            if (Arrays.binarySearch(fibonacciArray, number) == n-1) {
                System.out.println(number + " \n");
            }else{
                System.out.print(number + " ");
            }
        }
    }

    public void returnNth(int n){
        int[] fibonacciArray = new int[n];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacciArray[i] = fibonacciArray[i-1] + fibonacciArray[i-2];
        }
        System.out.println(fibonacciArray[n-1]);
    }

    public static void main(String[] args) {
        int n = 23;
        fibonacci fibonacci = new fibonacci();
        fibonacci.returnAll(n);
        System.out.println("The Nth fibonacci number is: ");
        fibonacci.returnNth(n);
    }
}
