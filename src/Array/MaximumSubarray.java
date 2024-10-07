package Array;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        List<Integer> arr = new ArrayList<>();
        int start = 0; int end = 0;

        int i = 1;
        while (i < nums.length) {
            if (currSum < 0) {
                currSum = 0;
                start = i;
            }

            currSum += nums[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                end = i;
            }

            i++;
        }

        for (int k = start; k <= end; k++) {
            arr.add(nums[k]);
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println("max sum = " + maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        maxSubArray(new int[] {5,4,-1,7,8});
        maxSubArray(new int[] {1});
        maxSubArray(new int[] {-3, -2, -1, -4});
    }
}
