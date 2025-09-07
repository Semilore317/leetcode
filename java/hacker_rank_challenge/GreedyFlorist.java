package hacker_rank_challenge;

import java.util.Arrays;
import java.util.Collections;

public class GreedyFlorist {
    public static int getMinimumCost(int k, int[] c) {
        int totalCost = 0;

        Integer[] prices = new Integer[c.length];
        for (int i = 0; i < c.length; i++) {
            prices[i] = c[i];
        }

        Arrays.sort(prices, Collections.reverseOrder());
        //ensures we buy the most expensive flowers first, so the lowest multipliers are used on the highest costs

        for (int i = 0; i < prices.length; i++) {
        // (i/k) - number of times each friend has bought the flower
            totalCost += prices[i] * ((i/k) + 1);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] c = {1,2,3,4}; //c.length() =4, number of purchased flowers = 4
        int  k = 3; // number of people buying flowers
        System.out.println(getMinimumCost(k, c));
    }
}
