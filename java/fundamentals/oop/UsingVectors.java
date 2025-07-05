package fundamentals.oop;

import java.util.Vector;

public class UsingVectors {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        System.out.println(vector.lastElement());
        System.out.println(vector.elementAt(1));
        System.out.println(vector.get(1));
        vector.removeElementAt(1);
        System.out.println(vector);
//        vector.clear();

        // to confirm membership
        boolean isAMember = vector.contains(1);
    }
}
