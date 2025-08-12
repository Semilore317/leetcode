package week_1_challenge;

import java.util.*;

public class MinimumLoss {
    public static int minimumLoss(List<Long> price) {
        TreeSet<Long> sortedPrices = new TreeSet<>();
        long minimumLoss = Long.MAX_VALUE;

        for (long p : price) {
            // Find the smallest price greater than the current price
            Long higherPrice = sortedPrices.higher(p);
            if (higherPrice != null) {
                // If a higher price exists, calculate potential loss
                minimumLoss = Math.min(minimumLoss, higherPrice - p);
            }
            // Add the current price to the sorted set
            sortedPrices.add(p);
        }
        return (int) minimumLoss;
   }

    public static void main(String[] args) {
        List<Long> price = new ArrayList<>();
        price.add(20L);
        price.add(15L);
        price.add(8L);
        price.add(2L);
        price.add(12L);

        System.out.println(minimumLoss(price));
    }

}

