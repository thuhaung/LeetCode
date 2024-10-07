package Array;

public class FirstAndLastPositionInSortedArray {
    public static int findFirstPos(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != nums[mid]) {
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int findLastPos(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != nums[mid]) {
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int[] firstAndLast(int[] nums, int target) {
        int[] result = new int[] {-1, 1};

        result[0] = findFirstPos(nums, target);
        result[1] = findLastPos(nums, target);

        for (int i : result) {
            System.out.println(i);
        }

        return result;
    }
    public static int[] firstAndLastBruteForce(int[] nums, int target) {
        int[] result = new int[] {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                    result[1] = i;
                }
                else if (i > result[1]) {
                    result[1] = i;
                }
            }
        }

        for (int i : result) {
            System.out.println(i);
        }

        return result;
    }

    public static void main(String[] args) {
//        firstAndLast(new int[] {5,7,7,8,8,10}, 8);
//        firstAndLast(new int[] {5,7,7,8,8,10}, 5);
//        firstAndLast(new int[] {}, 10);
//        firstAndLast(new int[] {10}, 10);
        firstAndLast(new int[] {2, 2}, 2);
    }
}
