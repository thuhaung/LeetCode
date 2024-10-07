package String;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);

            if (a != b) return false;

            i++;
            j--;
        }

        return true;
    }

    public static int countSubstringsBruteForce(String s) {
        List<String> substrings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            substrings.add(sb.toString());

            for (int j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));

                if (isPalindrome(sb.toString())) {
                    substrings.add(sb.toString());
                }
            }

            sb.setLength(0);
        }

        for (String x : substrings) {
            System.out.println(x);
        }

        System.out.println("size = " + substrings.size());
        return substrings.size();
    }

    public static void main(String[] args) {
        countSubstringsBruteForce("xkjkqlajprjwefilxgpdpebieswu");
    }
}
