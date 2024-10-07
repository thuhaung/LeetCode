package Array;

import java.util.*;

public class MaximumSumDistinctSubArraysLengthK {
    public static int maxSumOfSubArray(int[] nums, int k) {
        int maxSum = 0;
        int currSum = 0;

        if (k > nums.length) return maxSum;

        int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            currSum += nums[j];
            System.out.println("j = " + j + ", num = " + nums[j]);

            while (map.get(nums[j]) > 1) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                currSum -= nums[i];

                i++;
                System.out.println("duplicate found, inc i to " + i + ", num = " + nums[i]);
            }

            if (j - i + 1 == k) {
                if (currSum > maxSum) {
                    System.out.println("new max sum = " + currSum + " at i = " + i + ", j = " + j);
                    maxSum = currSum;
                }
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                currSum -= nums[i];
                i++;
            }

            j++;
        }

        System.out.println("max sum = " + maxSum);

        return maxSum;
    }

    public static void main(String[] args) {
        maxSumOfSubArray(new int[] {7,10,14,12,15,19}, 1);
    }
}
