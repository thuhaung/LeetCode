package Array;

public class TwoSum2 {
    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];

            if (sum > target) {
                end--;
            }
            else if (sum < target) {
                start++;
            }
            else {
                break;
            }
        }

        System.out.println((start + 1) + ", " + (end + 1));

        return new int[] {start + 1, end + 1};
    }


    public static void main(String[] args) {
        twoSum(new int[] {2,7,11,15}, 9);
    }
}
