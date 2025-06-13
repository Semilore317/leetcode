package fundamentals;

import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {
        int[] nums = new int[10];
        System.out.println(nums); // prints shit
        System.out.println(Arrays.toString(nums));


        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        System.out.println(Arrays.toString(nums));
    }
}
