package fundamentals.oop;

import javax.swing.*;
import java.util.ArrayList;

public class ReturnMax {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
       int a = Integer.parseInt(JOptionPane.showInputDialog("Enter the first number:"));
       int b = Integer.parseInt(JOptionPane.showInputDialog("Enter the second number:"));
       int c = Integer.parseInt(JOptionPane.showInputDialog("Enter the third number: "));
       list.add(a);
       list.add(b);
       list.add(c);
       int max = list.stream().max(Integer::compareTo).get();
       JOptionPane.showMessageDialog(null, "The maximum number is: " +  max);

       JOptionPane.showMessageDialog(null, "The max number is: "  + max);
    }
}

