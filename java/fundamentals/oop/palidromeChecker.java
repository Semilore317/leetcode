package fundamentals.oop;

import javax.swing.*;

public class palidromeChecker {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter a palindrome");
        int length = input.length();

        String reverse = new StringBuilder(input).reverse().toString();
        if (input.equals(reverse)) {
           JOptionPane.showMessageDialog(null, "Palindrome");
        }else {
            JOptionPane.showMessageDialog(null, "Not a palindrome");
        }
    }
}
