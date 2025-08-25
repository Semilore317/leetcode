package hacker_rank_challenge;

import java.util.ArrayList;
import java.util.List;

public class Arrays_DS {
    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = a.size() - 1; i > 0; i--) {
            res.add(a.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        int[] a = {1,2,3};
        arr.addAll(arr);
        System.out.println(reverseArray(arr));
    }
}
