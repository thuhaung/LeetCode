package Array;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (!set.add(i)) {
                System.out.println("duplicate num = " + i);
                return i;
            }
        }

        return 0;
    }

    public static int findDuplicateFloyd(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) break;
        }

        fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        System.out.println("duplicate num = " + slow);

        return slow;
    }

    public static void main(String[] args) {
        findDuplicateFloyd(new int[] {1, 3, 4, 2, 2});
        findDuplicate(new int[] {3, 3, 3, 3, 3});
    }
}
