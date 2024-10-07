package Array;

import java.util.*;

public class GroupAnagrams {
    public static boolean isAnagram(String s, String t) {
        if (t.length() > s.length() || t.length() * s.length() == 0) {
            return false;
        }

        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0 ) + 1);
        }

        for (char c : t.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) - 1);
        }

        for (char c : frequency.keySet()) {
            if (frequency.get(c) != 0) {
                return false;
            }
        }

        return true;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!map.containsKey(sortedStr)) {
                map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(strs[i]);
            }
            else {
                map.get(sortedStr).add(strs[i]);
            }
        }

        for (String key : map.keySet()) {
            anagrams.add(map.get(key));
        }

        for (List<String> i : anagrams) {
            System.out.println(i);
        }

        return anagrams;
    }

    public static void main(String[] args) {
        //groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
        groupAnagrams(new String[] {});
    }
}
