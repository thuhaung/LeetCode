package String;

public class LongestRepeatingCharacterReplacement {
    public static int bruteForce(String s, int k) {
        int max = 0;

        int start = 0;
        int end = 0;
        int[] frequency = new int[26];
        int maxCharCount = 0;

        while (end < s.length()) {
            char c = s.charAt(end);

            frequency[c - 'A']++;

            for (int i : frequency) {
                maxCharCount = Math.max(i, maxCharCount);
            }

            if ((end - start + 1) - maxCharCount <= k) {
                max = Math.max(end - start + 1, max);
            }
            else {
                frequency[s.charAt(start) - 'A']--;
                start++;
            }

            end++;
        }

        System.out.println("max = " + max);

        return max;
    }

    public static int longestSubString(String s, int k) {
        int max = 0;

        int start = 0;
        int end = 0;
        int[] frequency = new int[26];
        int mostFrequentCharCount = 0;

        while (end < s.length()) {
            char c = s.charAt(end);

            frequency[c - 'A']++;
            mostFrequentCharCount = Math.max(mostFrequentCharCount, frequency[c - 'A']);

            int subStringLen = (end - start) + 1;

            if (subStringLen - mostFrequentCharCount <= k) {
                if (subStringLen > max) {
                    System.out.println("new max found at start = " + start + ", end = " + end);
                    System.out.println("from char " + s.charAt(start) + " to char " + s.charAt(end));
                    max = subStringLen;
                }
            }
            else {
                frequency[s.charAt(start) - 'A']--;
                start++;
            }

            end++;
        }

        return max;
    }

    public static void main(String[] args) {
        bruteForce("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4);
    }
}
