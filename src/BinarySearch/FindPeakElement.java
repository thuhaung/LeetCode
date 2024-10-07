package BinarySearch;

public class FindPeakElement {
    public static int peakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            }
            else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(peakElement(new int[] {1,2,1,3,5,6,4}));
    }
}
