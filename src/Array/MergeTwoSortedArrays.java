package Array;

public class MergeTwoSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            }
            else {
                nums1[k] = nums1[i];
                i--;
            }

            k--;
        }

        while (j >= 0 && k >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        for (int x : nums1) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
//        merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2, 5, 6}, 3);
//        merge(new int[] {1}, 1, new int[] {0}, 0);
//        merge(new int[] {0}, 0, new int[] {1}, 1);
        //merge(new int[] {2, 0}, 1, new int[] {1}, 1);
        //merge(new int[] {1, 2, 4, 5, 6, 0}, 5, new int[] {3}, 1);
        merge(new int[] {3, 0, 0, 0, 0, 0}, 1, new int[] {1, 2, 4, 5, 6}, 5);
    }
}
