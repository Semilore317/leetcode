package fundamentals.oop;

import java.util.Scanner;

public class MathExpressions {
    public static void main(String[] args) {
        /*Part 1*/
        int l, b, k, h;
        double e = Math.E;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter l: ");
        l = input.nextInt();

        System.out.print("Enter b: ");
        b = input.nextInt();

        System.out.print("Enter k: ");
        k = input.nextInt();

        System.out.print("Enter h: ");
        h = input.nextInt();

        double solution = ((2*(l+b))/Math.pow(k, 2)) + Math.pow(e, -h);
        System.out.println(solution);

        /*Part 2*/
        double pi = Math.PI;
        int r, n;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter r: ");
        r = in.nextInt();

        System.out.print("Enter n: ");
        n = in.nextInt();

        double ans = pi*(Math.pow(r,n)) - Math.log(pi/2);
        System.out.println(ans);
    }
}
