package Array;

import java.util.ArrayList;
import java.util.List;

public class SubArrayProdLessThanK {
    public static int numOfSubArray(int[] nums, int k) {
        int count = 0;

        int left = 0;
        int right = 0;
        int prod = 1;

        while (right < nums.length) {
            prod *= nums[right];

            while (left <= right && prod >= k) {
                prod /= nums[left];
                left++;
            }

            count += right - left + 1;

            right++;
        }

        System.out.println("count = " + count);

        return count;
    }

    public static void main(String[] args) {
        numOfSubArray(new int[] {1, 0, 2, 2}, 4);
    }
}
