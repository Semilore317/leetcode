package fundamentals.oop;

public class times {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int Times = i * j;
                System.out.print("|" + Times + "\t");
            }
            System.out.println("");
        }
    }
}
