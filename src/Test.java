import DataStructure.ListNode;

import java.util.*;

public class Test {
//    public static String solution(int AA, int AB, int BB) {
//        StringBuilder sb = new StringBuilder();
//
//        int n = (AA + AB + BB) * 2;
//
//        if (BB > AA) {
//            sb.append("BB");
//            BB--;
//        }
//        else if (AB > AA || AB > BB) {
//            sb.append("AB");
//            AB--;
//        }
//        else if (AA > BB) {
//            sb.append("AA");
//            AA--;
//        }
//
//        for (int i = sb.length(); i < n; i += 2) {
//            if (i > 0 && i > sb.length()) {
//                break;
//            }
//
//            if (BB > 0 && (sb.isEmpty() || sb.charAt(i - 1) != 'B')) {
//                sb.append("BB");
//                BB--;
//            }
//            else if (AB > 0 && (sb.isEmpty() || sb.charAt(i - 1) != 'A')) {
//                sb.append("AB");
//                AB--;
//            }
//            else if (AA > 0 && (sb.isEmpty() || sb.charAt(i - 1) != 'A')) {
//                sb.append("AA");
//                AA--;
//            }
//        }
//
//        System.out.println(sb.toString());
//        System.out.println(sb.length());
//
//        return sb.toString();
//    }

    public static String solution(int[] A) {
        int n = A.length;

        if (n < 3) return "impossible";

        int sum = 0;

        for (int i : A) {
            sum += i;
        }

        if (sum % 3 != 0) {
            return "impossible";
        }

        sum /= 3;
        boolean[][][] dp = new boolean[sum + 1][sum + 1][sum + 1];
        dp[0][0][0] = true;

        int[][][] result = new int[sum + 1][sum + 1][sum + 1];

        for (int num : A) {
            for (int i = sum; i >= 0; i--) {
                for (int j = sum; j >= 0; j--) {
                    for (int k = sum; k >= 0; k--) {
                        if (i >= num && dp[i - num][j][k]) {
                            dp[i][j][k] = true;
                            result[i][j][k] = 1;
                        }
                        if (j >= num && dp[i][j - num][k]) {
                            dp[i][j][k] = true;
                            result[i][j][k] = 2;
                        }
                        if (k >= num && dp[i][j][k - num]) {
                            dp[i][j][k] = true;
                            result[i][j][k] = 3;
                        }
                    }
                }
            }
        }

        if (!dp[sum][sum][sum]) {
            return "impossible";
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        int i = sum, j = sum, k = sum;

        for (int index = n - 1; index >= 0; index--) {
            if (result[i][j][k] == 1) {
                list.get(0).add(index);
                i -= A[index];
            } else if (result[i][j][k] == 2) {
                list.get(1).add(index);
                j -= A[index];
            } else if (result[i][j][k] == 3) {
                list.get(2).add(index);
                k -= A[index];
            }
        }

        char[] chars = new char[n];

        for (int x = 0; x < list.size(); x++) {
            System.out.println(list.get(x));
            char c = 'R';

            if (x == 1) {
                c = 'G';
            }
            else if (x == 2) {
                c = 'B';
            }

            for (int y = 0; y < list.get(x).size(); y++) {
                chars[list.get(x).get(y)] = c;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        solution(new int[] {1,2,3,4,4,5,8});
    }
}
