package String;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                if (sb.length() != 0) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
            else {
                sb.append(s.charAt(i));
            }

            i++;
        }

        if (sb.length() != 0) {
            list.add(sb.toString());
            sb.setLength(0);
        }

        for (int j = list.size() - 1; j >= 0; j--) {
            sb.append(list.get(j));

            if (j != 0) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());

        return sb.toString();
    }

    public static void main(String[] args) {
        reverseWords("the sky is blue");
        reverseWords("  hello world  ");
        reverseWords("");
        reverseWords("a good   example");
    }
}
