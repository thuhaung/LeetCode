package Array;

public class SingleElementInSortedArray {
    public static int singleElementBruteForce(int[] nums) {
        int num = nums[0];

        // check boundary
        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        else if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i < nums.length - 1 && nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                num = nums[i];
                break;
            }

            if (i == nums.length - 1) {
                num = nums[i];
            }
        }

        System.out.println("num = " + num);

        return num;
    }

    public static int singleElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (
                (mid % 2 == 0 && mid + 1 <= nums.length - 1 && nums[mid] == nums[mid + 1]) ||
                (mid % 2 == 1 && mid - 1 >= 0 && nums[mid] == nums[mid - 1])
            ) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        System.out.println("num = " + nums[start]);

        return nums[start];
    }

    public static void main(String[] args) {
        singleElement(new int[] {1,1,2,2,3,3,4,8,8});
        //singleElement(new int[] {3,3,7,7,10,11,11});
    }
}
