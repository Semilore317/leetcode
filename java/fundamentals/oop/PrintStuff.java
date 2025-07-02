package fundamentals.oop;

import javax.swing.*;

public class PrintStuff {
    public static void main(String[] args) {
        // This code requests for your age now and the current year. It then computes the year you were born and
        //reports back to you when you were born.

        //declare variables
        String name;
        int currentAge;
        int currentYear;

        name = JOptionPane.showInputDialog("Enter your name");
        currentAge = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
        currentYear = Integer.parseInt(JOptionPane.showInputDialog("Enter current year"));

        int birthYear = currentYear - currentAge;


        System.out.println("Hello, " + name + "! \n" + "Your year of birth is " + birthYear );
    }
}
