package fundamentals.oop;

public class Stat {
    public int mean(int[] array) {
        int sum = 0;
        for (int value : array){
            sum += value;
        }
        return sum / array.length;
    }
    public int standardDeviation(int[] array) {
        int sum = 0;
        for (int value : array){
            sum += Math.pow(value-mean(array), 2);
        }
        return sum / array.length;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        Stat stat = new Stat();
        System.out.println(stat.mean(array));
        System.out.println(stat.standardDeviation(array));
        System.out.println(7 >> 1);

    }
}
