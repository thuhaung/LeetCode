package String;

public class LongestSubStringWithoutRepeatingCharacters {
    public static int longestSubString(String s) {
        if (s.isEmpty()) return 0;

        int[] map = new int[256];

        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(start));

        while (end < s.length()) {
            map[s.charAt(end)]++;

            while (map[s.charAt(end)] > 1) {
                //System.out.println("duplicate char = " + s.charAt(end) + " at end = " + end);

                map[s.charAt(start)]--;
                start++;
            }

            if (end - start + 1 > sb.length()) {
                sb.replace(0, sb.length(), s.substring(start, end + 1));
                //System.out.println("new sb = " + sb.toString());
            }

            end++;
        }

        System.out.println(sb.toString());

        return sb.length();
    }


    public static void main(String[] args) {
        longestSubString("");
        longestSubString("abcabcbb");
        longestSubString("pwwkew");
        longestSubString("bbbb");
    }
}
