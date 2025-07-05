package fundamentals.oop;

public class StepMean {
    public static void main(String[] args) {
        //Write a program segment to compute the average value of all data stored in even positions (2,
        //4, 6, …) inside a one-dimensional array, assuming data has been stored into the array initially.

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int sum = 0;
        int stepCount = 0;
        int mean;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                sum += arr[i];
                stepCount++;
            }
        }
        mean = sum / stepCount;
        System.out.println(mean);
    }
}
