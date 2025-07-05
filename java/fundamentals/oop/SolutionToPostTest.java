package fundamentals.oop;

public class SolutionToPostTest {
    public static void main(String[] args) {
        //Consider the following program
        //segment/snippet:
        //String univer = “My School is very good”;
        //String Uni = “my school is very Good”;
        //Write Java snippets to:
        //a. Get the total length of the string univer.
        //b. Compare if the two strings are equal, not minding letter cases.
        //c. Print out only “University is good” from univer
        //d. Reverse the string Uni
        //e. Get the last index of ‘s’from the string univer

        String univer = "My School is very good";
        String Uni = "my school is very Good";

        System.out.println(univer.length());
        System.out.println(univer.equalsIgnoreCase(Uni));
        System.out.println(univer.substring(0, 13) + univer.substring(18));

        //reverse Uni
        StringBuilder str = new StringBuilder(univer);
        str.reverse();
        System.out.println(str.toString());

        System.out.println(univer.lastIndexOf("s"));
    }
}
