package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                System.out.println("nums[i] = " + nums[i]);
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];

                    if (sum < 0) {
                        start++;
                    }
                    else if (sum > 0) {
                        end--;
                    }
                    else {
                        List<Integer> triplet = new ArrayList<>();

                        triplet.add(nums[i]);
                        triplet.add(nums[start]);
                        triplet.add(nums[end]);

                        result.add(triplet);

                        start++;
                        while (nums[start] == nums[start - 1] && start < end) {
                            start++;
                        }
                    }
                }
            }
        }

        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }

        return result;
    }

    public static void main(String[] args) {
        threeSum(new int[] {0,0,0,0});
    }
}
