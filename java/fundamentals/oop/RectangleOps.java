package fundamentals.oop;

import javax.swing.*;
import java.util.Scanner;

public class RectangleOps {
    /*APPROACH 1: Using GUI*/
    // import swing
    // prompt for length and breadth
    // return area and perimeter

    /*APPROACH 2: Using Terminal*/
    // import scanner class
    // prompt for length and breadth
    // return area and perimeter
    public static void main(String[] args) {
        int area, perimeter;

        String length_input = JOptionPane.showInputDialog("Enter the length of the rectangle");
        String width_input = JOptionPane.showInputDialog("Enter the width of the rectangle");

        int length = Integer.parseInt(length_input);
        int width = Integer.parseInt(width_input);

        area = length * width;
        perimeter = 2*(length + width);

        JOptionPane.showMessageDialog(null, "The area of the rectangle is: " + area);
        JOptionPane.showMessageDialog(null, "The perimeter of the rectangle is: " + perimeter);

        int a, p;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the rectangle: ");
        int l = input.nextInt();

        System.out.print("Enter the width of the rectangle: ");
        int w = input.nextInt();

        a = l * w;
        p = 2*(l+w);

        System.out.println("The area of the rectangle is: " + a);
        System.out.println("The perimeter of the rectangle is: " + p);
    }
}
