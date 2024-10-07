package Array;

public class RotateArray {
    public static void rotateArray(int[] nums, int k) {
        if (k != 0 || k % nums.length != 0) {
            int[] rotatedArr = new int[nums.length];
            k = k % nums.length;

            for (int i = 0; i < nums.length; i++) {
                if (i < nums.length - k) {
                    System.out.println("at i = " + i + ", new index = " + (i + k));
                    rotatedArr[i + k] = nums[i];
                }
                else {
                    System.out.println("at i = " + i + ", new index = " + ((i + k)  % nums.length));
                    int index = (i + k) % nums.length;
                    rotatedArr[index] = nums[i];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                System.out.println(rotatedArr[i]);
                nums[i] = rotatedArr[i];
            }
        }
    }

    public static void main(String[] args) {
        rotateArray(new int[] {-1,-100,3,99}, 2);
    }
}
