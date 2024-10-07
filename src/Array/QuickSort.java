package Array;

import java.util.Random;

public class QuickSort {
    public static void implementQuickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println("\n-----------------------");
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (end <= start) return;

        int pivot = getRandomPivot(nums, start, end);
        System.out.println("pivot = " + pivot);

        quickSort(nums, start, pivot);
        quickSort(nums, pivot + 1, end);
    }

    public static int getRandomPivot(int[] nums, int start, int end) {
        Random random = new Random();
        int randomIndex = (start) + (int)(Math.random() * (end - start + 1));

        int pivot = nums[randomIndex];
        int i = start - 1;
        int j = end + 1;

        while (true) {
            do {
                i++;
            } while (nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if (i >= j) return j;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static int getPivot(int[] nums, int start, int end) {
        int i = start - 1;
        int pivot = nums[end];

        for (int j = start; j <= end; j++) {
            if (nums[j] <= pivot) {
                i++;

                if (i < j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        System.out.println("pivot = " + i);
        return i;
    }

    public static void main(String[] args) {
        implementQuickSort(new int[] {-2, 3, -5});
        //implementQuickSort(new int[] {2,2,2,1});
    }
}
