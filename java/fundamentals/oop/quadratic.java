package fundamentals.oop;

import javax.swing.*;
import java.util.Scanner;

public class quadratic {
    public static void main(String[] args) {
        // ax^2 + bx + c = 0
        // x = (-b +- (b^2 - 4ac))/2a

        System.out.print("Enter three numbers a, b, c for the model quadratic: \n");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        double determinant = (double) (Math.pow(b, 2) - 4 * a * c);
        double x_1 = (int) (-b + Math.sqrt(determinant)) / (2 * a);
        double x_2 = (int) (-b - Math.sqrt(determinant)) / (2 * a);

        System.out.println("The solution is " + x_1 + " and " + x_2);
    }
}
