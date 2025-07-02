package fundamentals.oop;

import javax.swing.*;

public class printUsingSwing {
    public static void main(String[] args) {
        // Declare variables
        String num1_input, num2_input;
        int num1,num2, sum;

        num1_input = JOptionPane.showInputDialog("Enter First Number");
        num2_input = JOptionPane.showInputDialog("Enter Second Number");

        num1 = Integer.parseInt(num1_input);
        num2 = Integer.parseInt(num2_input);
        sum = num1 + num2;
        JOptionPane.showMessageDialog(null, "The Sum is " + sum);
    }
}
