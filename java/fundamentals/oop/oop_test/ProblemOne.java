package fundamentals.oop.oop_test;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


/*
MATRIC: 243444
NAME: BANKOLE ABRAHAM OLUWASEMILORE
DEPT: COMPUTER SCIENCE
COURSE: CSC 235 (OBJECT ORIENTED PROGRAMMING
*/

/* BASIC CONCEPT */
// used jshell as a workaround instead of a complex chain of if-statements and for loops
// by default, jshell obeys BODMAS rule, so it removes the need for explicit definitions for BODMAS
// i added extra logic for exponentiation due to jshell's lack of features
// make the results color coded
// make use of an "exit" statement to terminate the program
/* Limitations for now... */
//    Regex for exponentiation fails for nested parentheses
//    ANSI colors probably won't work for all terminals

public class ProblemOne {
    public static void main(String[] args){
        // create a jshell instance and prepare to read input from the user
        try (JShell js = JShell.create();
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("\n JShell Calculator. Type \"exit\" to quit.");
            // listen for events triggered when JShell processes code snippets
            js.onSnippetEvent(event -> {
                if (event.status() == Snippet.Status.VALID && event.value() != null) {
                    // print result in green if the snippet is valid and returns a value
                    System.out.println("\u001B[32m-> " + event.value() + "\u001B[0m");
                } else if (event.status() == Snippet.Status.REJECTED) {
                    // show error message in red for rejected/invalid code
                    System.out.println("\u001B[31mError: Invalid input.\u001B[0m");
                }
            });
            // read and evaluate input in a loop
            while (true) {
                System.out.print("\n>>> ");
                String line = br.readLine();
                // exit condition
                if (line == null || line.trim().equalsIgnoreCase("exit")) {
                    break;
                }
                // ignore empty input
                if (line.trim().isEmpty()) {
                    System.out.println("(empty input ignored)");
                    continue;
                }
                // replace ^ with Math.pow for exponentiation - major pain
                //line = line.replaceAll("(\\d+(?:\\.\\d*)?)\\s*\\^\\s*(\\d+(?:\\.\\d*)?)", "Math.pow($1, $2)")
                // Inside the while loop, replace the exponentiation line
                line = line.replaceAll("((?:\\((?:[^()]+|\\([^()]+\\))*\\)|-?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?))\\s*\\^\\s*((?:\\((?:[^()]+|\\([^()]+\\))*\\)|-?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?))", "Math.pow($1, $2)");
                // account for parentheses multiplication
                //line = line.replaceAll("(\\d+())", "(Math.multiply($1, $2))");
                try {
                    // evaluate input using JShell
                    List<SnippetEvent> events = js.eval(line);
                    if (events.isEmpty()) {
                        System.out.println("(no output)");
                    }
                } catch (Exception e) {
                    // catch runtime exceptions and print in red
                    System.out.println("\u001B[31mException: " + e.getMessage() + "\u001B[0m");
                }
            }
            System.out.println("\nExiting Calculator Goodbye!"); //shutdown message
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}