package Array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            }
            else {
                nums[index] = -nums[index];
            }
        }

        for (int i : duplicates) {
            System.out.println(i);
        }

        return duplicates;
    }

    public static void main(String[] args) {
        findDuplicates(new int[] {4,3,2,7,8,2,3,1});
        findDuplicates(new int[] {1});
    }
}
