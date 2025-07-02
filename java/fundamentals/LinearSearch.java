package fundamentals;

import java.util.Set;

public class LinearSearch {
    public Boolean linearSearch(Set<Integer> set, int target) {
        for (Integer element: set){
            if (element.equals(target)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int target = 12;
        Set<Integer> set = Set.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        LinearSearch ls = new LinearSearch();
        System.out.println(ls.linearSearch(set, target));
    }
}
