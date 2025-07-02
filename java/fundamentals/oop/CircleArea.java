package fundamentals.oop;

import javax.swing.*;
import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        //Computing the area and perimeter of a circle
        /*
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the radius of the circle: ");
        double radius = input.nextDouble();

        double area = Math.PI * radius * radius;
        System.out.println("The area of the circle is " + area);
        */

        String radiusInput;
        double radius;
        double area;

        radiusInput = JOptionPane.showInputDialog("Enter radius");
        radius = Double.parseDouble(radiusInput);

        area = Math.PI * radius * radius;

        JOptionPane.showMessageDialog(null, "The area of the circle is " + area);
    }
}
