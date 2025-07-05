package fundamentals.oop;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String str = "Hello World";
        int length = str.length();

        String word = str.substring(0);
        System.out.println(word);

        String firstWord = str.substring(0, 5);
        System.out.println(firstWord);

        String lastWord = str.substring(length - 5);
        System.out.println(lastWord);

        String e = String.valueOf(str.charAt(1));
        System.out.println(e);

        char ch = str.charAt(3);

        int indexOfe = str.indexOf("l");
        System.out.println(indexOfe);

        String upper = str.toUpperCase();

        char[] chars = word.trim().toCharArray();
        System.out.println(Arrays.toString(chars));
    }
}
