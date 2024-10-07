package Array;

import java.util.Arrays;
import java.util.Comparator;

public class CarPooling {
    public static boolean canCarPool(int[][] trips, int capacity) {
        int currCapacity = 0;
        int currLocation = 0;
        int currTrip = 0;
        int n = trips.length;

        Arrays.sort(trips, (trip1, trip2) -> trip2[1] - trip1[1]);

        // num of passengers, from, to
        // 2 1 5
        // 3 3 7
        while (currLocation <= trips[n - 1][2]) {
            if (currLocation == trips[currTrip][1]) {
                currCapacity += trips[currTrip][0];
            }

            currLocation++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canCarPool(new int[][] {{3,3,7},{2,1,5}}, 4));
    }
}
