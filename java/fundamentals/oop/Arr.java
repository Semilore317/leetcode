package fundamentals.oop;

import java.util.Arrays;
import java.util.Scanner;

public class Arr {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        //System.out.println(Arrays.toString(arr));

        int[] array = new int[3];
        //System.out.println(Arrays.toString(array));

        Scanner input = new Scanner(System.in);

        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                arr[i][j] = input.nextInt();
            }
        }

        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
