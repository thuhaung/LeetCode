package Array;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int bruteForce(int[] nums) {
        if (nums.length < 2) return nums.length;

        List<List<Integer>> subsequences = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> subsequence = new ArrayList<>();
            subsequence.add(nums[i]);
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i] && nums[j] > subsequence.get(subsequence.size() - 1)) {
                    subsequence.add(nums[j]);
                }
            }

            subsequences.add(subsequence);
        }

        int max = 0;
        for (List<Integer> subsequence : subsequences) {
            System.out.println(subsequence);
            max = Math.max(subsequence.size(), max);
        }

        return max;
    }

    public static void main(String[] args) {
        bruteForce(new int[] {0,1,0,3,2,3});
    }
}
