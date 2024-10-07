package Array;

import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        if (words.length == 0) {
            return result;
        }

        Map<String, Integer> frequency = new HashMap<>();

        for (String s : words) {
            frequency.put(s, frequency.getOrDefault(s, 0) + 1);
        }

        List<String>[] buckets = new List[words.length + 1];

        for (String key : frequency.keySet()) {
            int val = frequency.get(key);

            if (buckets[val] == null) {
                buckets[val] = new ArrayList<>();
            }

            buckets[val].add(key);
        }

        int index = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                Collections.sort(buckets[i]);

                for (int j = 0; j < buckets[i].size(); j++) {
                    if (index == k) {
                        break;
                    }

                    result.add(buckets[i].get(j));
                    index++;
                }
            }
        }

        System.out.println("Top k frequent words:");
        for (String s : result) {
            System.out.println(s);
        }

        return result;
    }

    public static void main(String[] args) {
        topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2);
        topKFrequent(new String[] {}, 2);
    }
}
