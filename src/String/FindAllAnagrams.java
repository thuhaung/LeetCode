package String;

import java.util.*;

public class FindAllAnagrams {
    public static boolean isAnagram(String s, String p) {
        if (p.length() != s.length()) {
            return false;
        }

        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            frequency.put(p.charAt(i), frequency.getOrDefault(p.charAt(i), 0) - 1);
        }

        for (char c : frequency.keySet()) {
            if (frequency.get(c) != 0) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> findAnagramsBruteForce(String s, String p) {
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if (p.length() > s.length() || p.isEmpty()) {
            return result;
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            sb.setLength(0);
            char c = s.charAt(i);

            //System.out.println("c = " + c);

            if (p.indexOf(c) != -1) {
                sb.append(c);

                if (isAnagram(sb.toString(), p)) {
                    //System.out.println("is anagram, sb = " + sb.toString());
                    result.add(i);
                }

                for (int j = i + 1; j < s.length(); j++) {
                    char d = s.charAt(j);

                    //System.out.println("d = " + d);

                    if (p.indexOf(d) == -1) {
                        break;
                    }
                    else {
                        sb.append(d);

                        if (sb.toString().length() > p.length()) {
                            break;
                        }

                        if (isAnagram(sb.toString(), p)) {
                            //System.out.println("is anagram, sb = " + sb.toString());
                            result.add(i);
                        }
                    }
                }
            }

            //System.out.println("---------------------------------------");
        }

        for (int i : result) {
            System.out.println("at index " + i + ", char = " + s.charAt(i));
        }

        System.out.println("---------------------------------------");

        return result;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length() || p.isEmpty()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] hCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int start = 0;
        int end = 0;

        while (end < s.length()) {
            hCount[s.charAt(end) - 'a']++;

            if (end - start == p.length() - 1) {
                if (Arrays.equals(hCount, pCount)) {
                    result.add(start);
                }

                hCount[s.charAt(start) - 'a']--;
                start++;
            }

            end++;
        }

        for (int x : result) {
            System.out.println("at index " + x + ", char = " + s.charAt(x));
        }

        return result;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
        findAnagrams("abab", "ab");
        findAnagrams("", "");
        findAnagrams("aaaa", "a");
    }
}
