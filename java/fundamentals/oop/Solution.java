package fundamentals.oop;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //The method, Arrays.sort(arrayName) can only sort an array in ascending order, implement a
        //program that will sort an array in descending order using bubble sorting algorithm or any other you
        //know.

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.sort(arr);
        try {
            int msg = Arrays.binarySearch(arr, 55);
            if(0 < msg && msg < arr.length) {
                System.out.println(arr[msg]);
            }else{
                System.out.println("Not found");
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
