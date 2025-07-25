package fundamentals.oop.cryptography;

import javax.swing.*;

import static fundamentals.oop.cryptography.ShiftCipher.decrypt;
import static fundamentals.oop.cryptography.ShiftCipher.encrypt;

public class CaesarCipher {
    public static void main(String[] args) {
        String original = JOptionPane.showInputDialog("Enter text to be encrpyted: ");
        int key = 3; // caesarian cipher has a default value of 3

        String encrypted = encrypt(original, key);
        String decrypted = decrypt(encrypted, key);

        JOptionPane.showMessageDialog(null, "The encrypted text is: \n4" + encrypted);
    }
}
