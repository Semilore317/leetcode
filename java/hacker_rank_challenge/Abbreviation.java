package hacker_rank_challenge;

public class Abbreviation {
    public static String abbreviation(String a, String b) {
        /* NAIVE APPROACH */
        //// operations that can be done:
        //        // 1. capitalize select letters in a
        //        // 2. delete the remaining lowercase letters in a
        //
        //        // two pointer approach
        //
        //        int i = 0; // pointer for a
        //        int j = 0; // pointer for b
        //
        //        while (i < a.length()) {
        //            char charA = a.charAt(i);
        //
        //            // if there's a match
        //            if (j < b.length() && Character.toUpperCase(charA) == b.charAt(j)) {
        //                if (Character.isUpperCase(charA) && charA != b.charAt(j)) {
        //                    return "NO"; // can't change an uppercase char
        //                }
        //                i++;
        //                j++;
        //            } else if (Character.isLowerCase(charA)) {
        //                i++; // skip this lowercase character - basically "delete" it
        //            } else {
        //                return "NO"; // uppercase letter that doesn't match
        //            }
        //        }
        //
        //        return j == b.length() ? "YES" : "NO";

        /* DYNAMIC PROGRAMMING APPROACH */
        int m = a.length();
        int n = b.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j]) {
                    // Case 1: If the current characters match (or can be capitalized to match)
                    if (j < n && Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
                        dp[i + 1][j + 1] = true;
                    }
                    // Case 2: If the character in `a` is lowercase, we can skip it
                    if (Character.isLowerCase(a.charAt(i))) {
                        dp[i + 1][j] = true;
                    }
                }
            }
        }

        if (dp[m][n]) {
            return "YES";
        }else{
            return "NO";
        }
    }
    public static void main(String[] args) {
        //String a = "AbcDE";
        //String b = "ABDE";
        String a = "daBcd";
        String b = "ABC";
        System.out.println(abbreviation(a, b));
    }
}