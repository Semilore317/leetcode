package fundamentals.oop.cryptography;

import javax.swing.*;

public class ShiftCipher {
    // Encrypts text using a shift cipher with the specified shift value
    public static String encrypt(String plaintText, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : plaintText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + key) % 26 + base));
            } else {
                result.append(c); // Non-letter characters remain unchanged
            }
        }
        return result.toString();
    }

    // Decrypts plaintText using a key cipher with the specified key value
    public static String decrypt(String plaintText, int key) {
        return encrypt(plaintText, 26 - key); // Decryption is encryption with inverse key
    }

    // Main method to demonstrate the key cipher
    public static void main(String[] args) {
//        String original = "Hello, World!";
//        int key = 5;

        String original = JOptionPane.showInputDialog("Enter text to be encrpyted: ");
        int key = Integer.parseInt(JOptionPane.showInputDialog("Enter key to use for encryption: "));


        String encrypted = encrypt(original, key);
        String decrypted = decrypt(encrypted, key);

//        System.out.println("Original: " + original);
//        System.out.println("Encrypted: " + encrypted);
//        System.out.println("Decrypted: " + decrypted);

        JOptionPane.showMessageDialog(null, "The encrypted text is: \n4" + encrypted);
    }
}