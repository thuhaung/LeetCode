package Stack;

import java.util.Arrays;

public class CarFleet {
    public static int carFleet(int target, int[] pos, int[] speed) {
        Arrays.sort(pos);
        int fleet = 1;

        double[] timeUntilTarget = new double[pos.length];

        for (int i = 0; i < pos.length; i++) {
            timeUntilTarget[i] = (double) (target - pos[i]) / speed[i];
        }

        double curr = 0;

        for (int i = timeUntilTarget.length - 1; i >= 0; i--) {
            if (timeUntilTarget[i] > curr) {
                curr = timeUntilTarget[i];
                i++;
            }
        }

        System.out.println(fleet);

        return fleet;
    }

    public static void main(String[] args) {
        carFleet(12, new int[] {10, 0, 5, 3, 8}, new int[] {2, 1, 1, 3, 4});
    }
}
