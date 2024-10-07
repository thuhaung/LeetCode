package Array;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static int[] topKElements(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> frequencyCount = new HashMap<>();

        for (int i : nums) {
            frequencyCount.put(i, frequencyCount.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Integer key : frequencyCount.keySet()) {
            int val = frequencyCount.get(key);

            if (buckets[val] == null) {
                buckets[val] = new ArrayList<>();
            }

            buckets[val].add(key);
        }

        int result[] = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    if (index == k) {
                        break;
                    }

                    result[index] = buckets[i].get(j);
                    index++;
                }
            }
        }

        System.out.println("Top k frequent elements:");
        for (int i : result) {
            System.out.print(i + " ");
        }

        return result;
    }

    public static void main(String[] args) {
        topKElements(new int[] {1}, 1);
    }
}
