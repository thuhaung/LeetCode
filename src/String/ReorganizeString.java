package String;

import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {
    public static String reorganizeString(String s) {
        int[] frequency = new int[26];

        int maxCount = 0;
        int maxChar = 0;

        for (char c : s.toCharArray()) {
            int index = c - 'a';

            frequency[index]++;

            if (frequency[index] > maxCount) {
                maxCount = frequency[index];
                maxChar = index;
            }
        }

        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }

        System.out.println("max char = " + (char)(maxChar + 'a'));

        char[] result = new char[s.length()];
        int i = 0;

        while (frequency[maxChar] > 0) {
            result[i] = (char) (maxChar + 'a');
            frequency[maxChar]--;
            i += 2;
        }

        for (int j = 0; j < frequency.length; j++) {
            while(frequency[j] > 0) {
                if (i >= result.length) {
                    i = 1;
                }
                System.out.println("i = " + i + " res[i] = " + (char) (j + 'a'));
                result[i] = (char) (j + 'a');
                frequency[j]--;
                i += 2;
            }
        }

        for (char c : result) {
            System.out.println(c);
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        reorganizeString("aaabbbcc");
    }
}
