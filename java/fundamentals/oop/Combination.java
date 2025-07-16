package fundamentals.oop;

public class Combination {
    public int  factorial(int n) {
        if(n == 0) return 1;
        return n*factorial(n-1);
    }
    public int combination(int n, int r) {
        return factorial(n)/(factorial(r)*factorial(n-r));
    }
    public static void main(String[] args) {
        Combination combination = new Combination();
        System.out.println(combination.combination(5,3));
    }
}
