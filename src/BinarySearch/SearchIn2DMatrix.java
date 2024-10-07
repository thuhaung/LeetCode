package BinarySearch;

public class SearchIn2DMatrix {
    public static int findRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (target > matrix[mid][0]) {
                if (target <= matrix[mid][matrix[mid].length - 1]) {
                    return mid;
                }
                start = mid + 1;
            }
            else if (target < matrix[mid][0]) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }

        return start;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowTargetIsIn = findRow(matrix, target);
        System.out.println("in row " + rowTargetIsIn);

        int start = 0;
        int end = matrix[rowTargetIsIn].length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (target > matrix[rowTargetIsIn][mid]) {
                start = mid + 1;
            }
            else if (target < matrix[rowTargetIsIn][mid]) {
                end = mid - 1;
            }
            else {
                return true;
            }
        }

        return target == matrix[rowTargetIsIn][start];
    }

    public static void main(String[] args) {
        searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 11);
    }
}
