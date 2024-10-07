package String;

import java.util.HashMap;
import java.util.Map;

public class LongestSemiRepetitiveSubString {
    public static int longestSubString(String s) {
        int max = 0;

        int start = 0;
        int end = 0;
        int pairCount = 0;
        Map<Integer, Integer> charPairs = new HashMap<>();

        while (end < s.length()) {
            if (end > 0) {
                if (s.charAt(end) == s.charAt(end - 1)) {
                    pairCount++;
                    charPairs.put(end - 1, end);
                }
            }

            while (pairCount >= 2) {
                if (charPairs.containsKey(start)) {
                    charPairs.remove(start);
                    pairCount--;
                }

                start++;
            }

            max = Math.max(end - start + 1, max);

            end++;
        }

        for (Map.Entry<Integer, Integer> entry : charPairs.entrySet()) {
            System.out.println("pair exists from " + entry.getKey() + ", char = " + s.charAt(entry.getKey()));
        }

        System.out.println("max = " + max);

        return max;
    }

    public static int betterLongestSubString(String s) {
        int max = 0;

        int start = 0;
        int end = 0;
        boolean found = false;

        while (end < s.length()) {
            if (end > 0) {
                if (s.charAt(end) == s.charAt(end - 1)) {
                    if (!found) {
                        found = true;
                    }
                    else {
                        start++;

                        while (s.charAt(start) != s.charAt(start - 1)) {
                            start++;
                            System.out.println("incremented start to " + start);
                        }
                    }
                }
            }

            max = Math.max(end - start + 1, max);
            end++;
        }

        System.out.println("max = " + max);

        return max;
    }

    public static void main(String[] args) {
        //longestSubString("52233");
//        longestSubString("5494");
        betterLongestSubString("1111111");
    }
}
