import javax.swing.JOptionPane;

public class WordPerLine {
    public static void main(String[] args) {
        // Read a line of text from the keyboard using JOptionPane
        String input = JOptionPane.showInputDialog("Enter a line of text (letters and blanks only):");

        // Check if input is null (user cancels input dialog)
        if (input == null || input.trim().isEmpty()) {
            System.out.println("No input provided.");
            return;
        }

        // Split the input string into words based on spaces
        String[] words = input.trim().split("\\s+");

        // Display each word on a separate line
        for (String word : words) {
            System.out.println(word);
        }

        // Display the number of words
        System.out.println("Number of words: " + words.length);
    }
}