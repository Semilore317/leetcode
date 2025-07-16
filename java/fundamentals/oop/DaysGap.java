package fundamentals.oop;

public class DaysGap {
    public static void main(String[] args) {
        //Write a function in Java that accepts two dates in a year and computes the number of days
        //between them. State the conditions under which the function may work properly (regarding
        //the ordering of input to the function).
        int year_1  =   1995;
        int year_2  =   2005;
        int gap =    0;
        for(int i = year_1; i < year_2; i++) {
            if(i%4==0){
                gap+=366;
            }else{
                gap+=365;
            }
        }
        System.out.println(gap);
    }
}
