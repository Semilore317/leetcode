package fundamentals.oop;

import java.util.Scanner;

public class printName {
    public static void main(String[] args) {
        /*
        Scanner input = new Scanner(System.in);

        // Reading in the input a,b,c
        System.out.println("Enter the value of a ");
        int a = input.nextInt();

        System.out.println("Enter the value of b ");
        int b = input.nextInt();

        System.out.println("Enter the value of c ");
        int c = input.nextInt();

        // Reading String date
        System.out.println("Enter a name");
        String name = input.next();

        double sum = a + b + c;
        double avg = sum / 3;

        System.out.println("Hello "+ name +"\n The average of "+ a +", " + b + ", " + c + " is " + avg);
        */

        // This code requests for your age now and the current year. It then computes the year you were born and
        //reports back to you when you were born.

        String Name;
        int currentAge;
        int currentYear;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        Name = input.nextLine();

        System.out.println("Enter your age: ");
        currentAge = input.nextInt();

        System.out.println("Enter your year of birth: ");
        currentYear = input.nextInt();

        int birthYear = currentYear - currentAge;

        System.out.println("Hello, " + Name + "! \n" + "Your year of birth is " + birthYear );
    }
}
