package fundamentals.oop.oop_test;

import java.util.Scanner;

/*
MATRIC: 243444
NAME: BANKOLE ABRAHAM OLUWASEMILORE
DEPT: COMPUTER SCIENCE
COURSE: CSC 235 (OBJECT ORIENTED PROGRAMMING
*/

public class ProblemTwo {
    public static void main(String[] args) {
        // i made use of the inbuilt Scanner class to collect input via terminal
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer n to compute the first n numbers in the fibonacci sequence: ");
        int n = input.nextInt();
        // i defined an array to represent the numbers in the fibonacci sequence with equal length
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        if (n>=0){
            for (int i = 2; i < n; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
            for (int number : fibonacci) {
                System.out.print(number + " ");
            }
        }else{
            System.out.println("The fibonacci sequence does not exist");
        }
    }
}
