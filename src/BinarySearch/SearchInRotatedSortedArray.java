package BinarySearch;

public class SearchInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) return 0;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            while (nums[start] == nums[end] && start < end) {
                start++;
                end--;
            }

            if (end > 0 && nums[end - 1] > nums[end]) {
                return end;
            }
            else if (end < nums.length - 1 && nums[end + 1] < nums[end]) {
                return end + 1;
            }

            int mid = start + (end - start) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
            else if (nums[mid] <= nums[end]) {
                end = mid;
            }
        }

        return start;
    }

    public static int search(int[] nums, int target) {
        int indexOfMinNum = findMin(nums);

        System.out.println("min at index " + indexOfMinNum);

        int end = target > nums[nums.length - 1] ? indexOfMinNum - 1 : nums.length - 1;
        int start = target > nums[nums.length - 1] ? 0 : indexOfMinNum;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }

        return nums[start] == target ? start : - 1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {1,1,1,1,1,1,1,2,1,1}, 2));
    }
}
