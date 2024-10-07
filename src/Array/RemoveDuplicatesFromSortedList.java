package Array;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedList {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 2;
        int j = 2;

        while (j < nums.length) {
            System.out.println("at j = " + j + ", nums[j] = " + nums[j]);
            System.out.println("at i = " + i + ", nums[i - 2] = " + nums[i - 2]);

            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }

            j++;
            System.out.println("--------------------------");
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        List<Integer> a = new ArrayList<>();

        System.out.println(removeDuplicates(nums));;
    }
}
