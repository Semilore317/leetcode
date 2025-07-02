package fundamentals.oop;

import java.util.Scanner;

public class DynamicAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            sum += arr[i];
        }
        double average = sum / n;
        System.out.println("The average of is: " + average);
    }
}
