package String;

public class IsSubsequence {
    public static boolean isSubsequence(String t, String s) {
        if (s.isEmpty()) return true;

        int i = 0;
        int j = 0;

        while (j < t.length()) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;

                if (i == s.length()) {
                    System.out.println("\nS IS SUBSEQUENCE\n");
                    return true;
                }
            }

            j++;
        }

        System.out.println("\nS IS NOT SUBSEQUENCE\n");

        return false;
    }

    public static void main(String[] args) {
        isSubsequence("ahbgdc", "abc");
        isSubsequence("ahbgdc", "axc");
        isSubsequence("abcde", "");
        isSubsequence("abcd", "adc");
    }
}
