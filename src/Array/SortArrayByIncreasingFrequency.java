package Array;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public static int[] sortArray(int[] nums) {
        int[] result = new int[nums.length];

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i : nums) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequency.entrySet());

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                if (a.getValue().equals(b.getValue())) {
                    return b.getKey() - a.getKey();
                }

                return a.getValue() - b.getValue();
            }
        });

        int i = 0;

        for (Map.Entry<Integer, Integer> entry : list) {
            int value = entry.getValue();

            while (value > 0) {
                result[i] = entry.getKey();
                value--;
                i++;
            }
        }

        for (int x : result) {
            System.out.println(x);
        }

        return result;
    }

    public static void main(String[] args) {
        //sortArray(new int[] {2,3,1,3,2});
        //sortArray(new int[] {1});
        //sortArray(new int[] {1,1,2,2,2,3});
    }
}
