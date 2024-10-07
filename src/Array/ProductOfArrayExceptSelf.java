package Array;

public class ProductOfArrayExceptSelf {
    public static int[] getPrefixProduct(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i];
        }

        return prefixProduct;
    }

    public static int[] getPostfixProduct(int[] nums) {
        int[] postfixProduct = new int[nums.length];
        postfixProduct[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            postfixProduct[i] = postfixProduct[i + 1] * nums[i];
        }

        return postfixProduct;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = getPrefixProduct(nums);
        int[] postfixProduct = getPostfixProduct(nums);

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = postfixProduct[i + 1];
            }
            else if (i == nums.length - 1) {
                result[i] = prefixProduct[i - 1];
            }
            else {
                result[i] = prefixProduct[i - 1] * postfixProduct[i + 1];
            }
        }

        for (int i : result) {
            System.out.println(i);
        }

        return result;
    }

    public static int[] productExceptSelfUsingDivision(int[] nums) {
        int[] result = new int[nums.length];
        int prod = 1;
        int zeroCount = 0;

        for (int i : nums) {
            if (i != 0) {
                prod *= i;
            }
            else {
                zeroCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroCount > 1) {
                    result[i] = 0;
                }
                else {
                    result[i] = prod;
                }
            }
            else if (zeroCount > 0) {
                result[i] = 0;
            }
            else {
                result[i] = prod / nums[i];
            }
        }

        for (int i : result) {
            System.out.println(i);
        }

        return result;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[] {1, 2, 3, 4});
    }
}
