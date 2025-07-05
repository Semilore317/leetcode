package fundamentals.oop;

import java.util.Arrays;
import java.util.Scanner;

public class StandardDeviation {
    public static void main(String[] args) {
        // intialize an ArrayList
        // use scanner to sequentially add each input to the arrayList four times

        int[] dataSet = new int[4];

        Scanner input = new Scanner(System.in);
        for (int i = 1; i < 5; i++) {
            try {
                System.out.println("Enter integer: " + i);
                dataSet[i - 1] = input.nextInt();
            }catch (Exception e) {
                System.out.println("Invalid input");
            }
        }

        double mean = (double) Arrays.stream(dataSet).sum() / dataSet.length;
        double variance = (double) Arrays.stream(dataSet).sum() / dataSet.length;
        double standardDeviation = Math.sqrt(variance);

        //System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + standardDeviation);
    }
}
