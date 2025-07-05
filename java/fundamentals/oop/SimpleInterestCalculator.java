package fundamentals.oop;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        // using swing
        // prompt for principal, rate, time
        // return simple interest

        String principal_input = JOptionPane.showInputDialog("Enter the principal amount");
        BigDecimal principal = BigDecimal.valueOf(Double.parseDouble(principal_input));

        String rate_input = JOptionPane.showInputDialog("Enter the rate amount");
        BigDecimal rate = BigDecimal.valueOf(Double.parseDouble(rate_input));

        String time_input = JOptionPane.showInputDialog("Enter the time in years");
        BigDecimal time = BigDecimal.valueOf(Double.parseDouble(time_input));

        BigDecimal simpleInterest = principal.multiply(rate).multiply(time).divide(BigDecimal.valueOf(100));
        simpleInterest = simpleInterest.setScale(2, BigDecimal.ROUND_HALF_UP);

        JOptionPane.showMessageDialog(null, "The Simple Interest: " + simpleInterest);


        Scanner input = new Scanner(System.in);

        System.out.println("Enter the principal amount");
        BigDecimal p = input.nextBigDecimal();

        System.out.println("Enter the interest rate");
        BigDecimal r = input.nextBigDecimal();

        System.out.println("Enter the time in years");
        BigDecimal t = input.nextBigDecimal();

        BigDecimal si = p.multiply(r).multiply(t).divide(BigDecimal.valueOf(100));
        si = si.setScale(2, BigDecimal.ROUND_HALF_UP);

        System.out.println("The Simple Interest: " + si);
    }
}
