package Array;

import java.util.ArrayList;
import java.util.List;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums[0] == target) {
            return 1;
        }

        int i = 0; int j = 0;
        int start = -1; int end = -1;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;

        List<Integer> subArray = new ArrayList<>();

        while (j < nums.length) {
            currSum += nums[j];

            while (currSum >= target) {
                start = i;
                minLength = Math.min(j - i + 1, minLength);

                currSum -= nums[i];
                i++;

                end = j;
            }

            j++;
        }

        while (start <= end && start != -1) {
            subArray.add(nums[start]);
            start++;
        }

        for (int x : subArray) {
            System.out.print(x + " ");
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        minSubArrayLen(7, new int[] {2,3,1,2,4,3});
        System.out.println();
        minSubArrayLen(4, new int[] {1,4,4});
        System.out.println();
        minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1});
        System.out.println();
        minSubArrayLen(11, new int[] {1,2,3,4,5});
    }
}
