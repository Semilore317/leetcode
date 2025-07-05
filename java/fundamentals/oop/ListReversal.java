package fundamentals.oop;

import java.util.Arrays;
import java.util.Collections;

public class ListReversal {
    static void reverse(int[] arr){
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;

        for (int i = 0; i > n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
        reverse(arr);
    }
}
